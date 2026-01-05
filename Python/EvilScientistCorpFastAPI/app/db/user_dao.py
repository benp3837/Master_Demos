from typing import List

from sqlalchemy.ext.asyncio import AsyncSession
from sqlalchemy.future import select

from app.db.user_table import UserTable
from app.models.user_model import UserModel


async def get_all_users(db_session: AsyncSession) -> List[UserModel]:
    result = await db_session.scalars(select(UserTable))

    # Convert SQLAlchemy objects to Pydantic models
    return [UserModel.model_validate(user) for user in result]


class UserDao:
    def __init__(self, db_session: AsyncSession):
        self.db_session = db_session

    async def create_user(self, user:UserModel):
        new_user = UserTable(username=user.username, password=user.password, email=user.email)
        self.db_session.add(new_user)
        await self.db_session.commit()
        await self.db_session.refresh(new_user)
        return new_user

    async def get_user_by_id(self, user_id: int):
        result = await self.db_session.execute(select(UserTable).where(UserTable.id == user_id))
        return result.scalar_one_or_none()
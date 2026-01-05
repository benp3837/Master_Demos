from sqlalchemy import MetaData
from sqlalchemy.ext.asyncio import AsyncSession, create_async_engine, async_sessionmaker
from sqlalchemy.ext.declarative import declarative_base

# Define the base class + schema for our _table.py files
Base = declarative_base(metadata=MetaData(schema="fastapi"))

# Tell SQLAlchemy which database to connect to (using plaintext credentials - NOT SAFE!)
DATABASE_URL = "postgresql+asyncpg://postgres:password@localhost:5432/postgres"

# Create the async engine
engine = create_async_engine(DATABASE_URL, echo=True)

# Create a session factory
async_session = async_sessionmaker(
    bind=engine,
    class_=AsyncSession,
    expire_on_commit=False
)

# Dependency to get the DB session
async def get_db() -> AsyncSession:
    async with async_session() as session:
        yield session


# Seems like we have async everything in this app! Why?
# async operations allow the app to handle multiple requests concurrently (at the same time).
# This is particularly beneficial for I/O-bound operations, which we see with HTTP and DB calls.
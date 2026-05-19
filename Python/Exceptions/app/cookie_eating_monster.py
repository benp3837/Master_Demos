"""
This Class represents a monster that eats cookies... a Cookie Monster if you will

He likes when you feed him cookies :)
He DOES NOT like when you feed him non-cookies.
    He will RAISE EXCEPTIONS if you don't feed him a cookie
"""
# TODO: If you want to review OOP, you can do a Food class with an "is_cookie" boolean
# TODO: Or make them do it themselves for a small practice/challenge

class CookieEatingMonster:

    def eat_cookie(self, food):
        if food != "cookie":
            raise NotACookieError(f"Disgusting. {food}.")
        else:
            print("Yum! Thanks for the cookie!")


# Custom Exception - NotACookieError - thrown when fed a non-cookie
class NotACookieError(Exception):
    def __init__(self, message):
        self.message = message

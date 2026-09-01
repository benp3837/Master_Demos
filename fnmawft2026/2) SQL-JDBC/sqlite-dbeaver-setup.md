# SQLite + DBeaver Setup (FNMA Environment)

DBeaver can't download SQLite driver files from the internet due to security measures. No surprise.

**The Fix (Big Picture):** If you installed the SQLite JDBC Gradle dependency already, you have what you need to make a DB and connect to it in DBeaver. 
When you create and connect to a DB in DBeaver, just point it at the SQLite JDBC JAR that Gradle already downloaded, INSTEAD of the drivers it tries to make you install. 

**If you've run my Project Skeleton, you already have the DB Driver files you need. That's the easiest way to get them IMO.**

This is all a bit annoying (thank you FNMA) but we need the SQLite dependency for the project anyway! So just setting up your project gives you what you need.

---

## Step 1: Find the JAR from Gradle Cache (Assumes you've installed the SQLite dependency in a Gradle app)

*NOTE: This is just a "find it" step, and you can skip to step 2 if you're confident*

Navigate to:
```
C:\Users\<your-username>\.gradle\caches\modules-2\files-2.1\org.xerial\sqlite-jdbc\3.49.1.0\
```
There will be a subfolder with a hash name, and the `.jar` file you need is inside it.

---

## Step 2: Point DBeaver at the JAR



1. In DBeaver, click the button that looks like a "plug with a plus" on the top left
2. Choose **SQLite** and hit **Next** (Ignore any prompts telling you to download a Driver)
3. Hit **Driver Settings** on the bottom right
3. Go to the **Libraries** tab
4. Click **Add File**
5. Navigate to the JAR file found above and select it
6. Delete the other 2 files sitting in the **Libraries** tab
7. Click OK

DBeaver will now use the local JAR instead of trying to download anything.

---

## Step 3: Create a New SQLite Database File

SQLite is file-based, so the database is literally just a `.db` file on disk.

When creating a new DBeaver connection:

1. Go back to the connection settings, under the **Main** tab where we started.
2. In the **Path** field, type a full path including the `.db` extension:
```
C:\Users\<your-username>\<wherever-you-want-your-db-to-live>\mydb.db
```
3. If the file doesn't exist yet, SQLite will create it automatically on first connection.

> A folder path or a name without an extension will cause:
> `"File opened that is not a DB file"`

4. You can now right click your new database -> SQL Editor -> New SQL Script. Run SQL commands in this canvas!

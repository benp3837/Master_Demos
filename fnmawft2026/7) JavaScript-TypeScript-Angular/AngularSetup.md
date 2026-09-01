# Angular Setup Steps

Angular is annoying to set up in the FNMA environment, but we requested a permission that makes it easier. We should have it by the time we're making Angular apps. 

Basically, we need to create our Angular apps in a specific folder in C: and change some configurations around to make calls to Nexus Repo instead of the public internet, like we do with Gradle apps. The different dependencies and .exe files that Angular needs to run will get blocked otherwise.

## Setup and Config

- First, open up VSCode and hit `file -> open -> and choose the C:/Developers folder`. We need to make our Angular apps in here.
- Once your folder is open in VSCode, hit `view -> terminal` to open a new VSCode integrated terminal. (Which is just convenient; You can open a seperate git bash terminal etc.)
- First off, set your registry to nexus (like we have to do in build.gradle files). `npm config set registry https://nexusrepository.fanniemae.com/nexus/repository/npm-all/`.
    - Make sure it DID get set to nexus with `npm get registry`

- Next, set strict-SSL to "false", or the proxy will stop us from using Angular. `npm config set strict-ssl false`
    - Test this with `npm ping`. You should get a "Pong" back.

- Some of you may need to install Angular itself. `npm install -g @angular/cli`

- Almost done. Now we just need to set an environment variable for npm.
    - In your laptop's search bar, search and choose `Edit environment variables for your account` 
    - Click into the `path` variable, and enter a new one: `C:\Users\[YOUR_USER_HERE]\AppData\Roaming\npm`

- **Finally, close your terminal and restart VSCode to get these changes to take!**
    - Confirm that your Angular installation worked by running `ng version`. You should see version 21.


## Creating and Using an Angular app

- Create an Angular App with "ng new"! `ng new your-app-name --skip-git`
- You can choose "no" and "none" for everything but **make sure to choose CSS as the styling framework**
- Now that your app is created, cd into it. `cd your-app-name`
- You should be able to run `ng serve -o` to render the app onto a new browser window. You'll see a bunch of prewritten template code.
- Remember to replace the template code in `app.html` and `app.css` with your own code.
- `ng g c components/your-component-name` to create a new component in a folder called "components" and get started on building out your project!

### General Reminders

- `ctrl + c` to kill your app's runtime.
- `ng serve` without the -o to rerun your app if it's already open in your browser.
- `ng g ___` works for a lot of different structures, not just components. `ng g s services/your-service-name` for example.
- Turn on autosave in VSCode to make your development more streamlined (webpage refreshes as you write code) `file -> autosave`.
- If you PULL an Angular app, you need to run `npm install` to get your node_modules (the dependencies folder). It gets .gitignored, and for good reason. It's huge.
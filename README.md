# Full Stack Clojure/Clojruescript

A complete full stack clojure/clojurescript project template using:

- Reagent & Re-frame for dom structure and state managment
- Shadow-cljs for hot realoding & development server
- Tailwind CSS for styling
- Http-kit/reitit as the REST server/router
- Hugsql for interacting with the sql database.

---

# Getting Started

Built using `clojure 1.10.1.739` + `java 12.0.1`

This project template requires a `psql` database.

In your console run, `mv .envrc_example .envrc` & enter your database information (I'm using direnv
to load my enviroment variables, feel free to use any software you prefer).

Run `npm i` to install the javascript dependancies

---

# Up & Running

`npm run start` will start the `shadow-cljs` development server & bundle `main.css` based off the `tailwind.config.js`

To run the http server, run `clj -M:run`

(ns backend.db
  (:require [aero.core   :as aero]
            [hugsql.core :as hugsql]))

(def env-config (aero/read-config "config.edn"))

(def db-spec
  {:classname   "org.postgresql.Driver"
   :subprotocol "postgresql"
   :subname     (:postgres-subname env-config)
   :user        (:postgres-user env-config)
   :password    (:postgres-pass env-config)})

(hugsql/def-db-fns "sql/users.sql")

(comment
  (create-users-table db-spec))

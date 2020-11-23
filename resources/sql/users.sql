-- :name create-users-table
-- :command execute
-- :result raw
-- :doc creates-users-table
CREATE TABLE users (
  id uuid    PRIMARY KEY DEFAULT uuid_generate_v4(),
  username   text NOT NULL,
  first_name text,
  last_name  text,
  email      text NOT NULL,
  created_at timestamptz NOT NULL DEFAULT NOW(),
  deleted_at timestamptz
);

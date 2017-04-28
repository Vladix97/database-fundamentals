ALTER TABLE minions
    ADD town_id INT,
    ADD CONSTRAINT FOREIGN KEY(town_id) REFERENCES towns(id);

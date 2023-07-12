INSERT INTO `authority` (authority_name)
SELECT *
FROM (SELECT 'ROLE_ADMIN') AS tmp
WHERE NOT EXISTS(
        SELECT authority_name FROM `authority` WHERE authority_name = 'ROLE_ADMIN'
    )
LIMIT 1;

INSERT INTO `authority` (authority_name)
SELECT *
FROM (SELECT 'ROLE_COACH') AS tmp
WHERE NOT EXISTS(
        SELECT authority_name FROM `authority` WHERE authority_name = 'ROLE_COACH'
    )
LIMIT 1;

INSERT INTO `authority` (authority_name)
SELECT *
FROM (SELECT 'ROLE_USER') AS tmp
WHERE NOT EXISTS(
        SELECT authority_name FROM `authority` WHERE authority_name = 'ROLE_USER'
    )
LIMIT 1;


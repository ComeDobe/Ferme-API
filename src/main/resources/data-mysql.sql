
INSERT INTO `utilisateur` (`id_utilisateur`, `created_date`, `last_modified_date`, `active`, `adresse`, `email`, `first_name`, `is_admin`, `last_name`, `password`, `telephone`) VALUES

(1,  UTC_TIMESTAMP(), UTC_TIMESTAMP(), b'0', '1 rue de Scherwiller', 'christian@hotmail.fr', 'Christian', b'0', 'Dobe', '$2a$10$00ch3DOx4WGE2WXbjpET9.KN.GH.vD2bgcRbilRn22rDFq6o291Q.', '14774587uu788'),
(2,  UTC_TIMESTAMP(), UTC_TIMESTAMP(), b'0', '5 avenue des Tilleuls', 'sophie.martin@gmail.com', 'Sophie', b'0', 'Martin', '$2a$10$wngQbJsWqQ/oLpvsXR0VDOi.ShD.YE.8E/Szd2Jvk3liLwPI2VD1K', '1542958420jj'),
(3,  UTC_TIMESTAMP(), UTC_TIMESTAMP(), b'0', '3 boulevard de la Libération', 'marc.dupont@yahoo.com', 'Marc', b'0', 'Dupont', '$2a$10$FCO3WVPj0gObbWXLg37EUu1Y5maF4nS27krS.VczGZLKSsztSjqQS', '14729580dd820'),
(4,  UTC_TIMESTAMP(), UTC_TIMESTAMP(), b'0', '10 rue du Moulin', 'julie.leclerc@outlook.com', 'Julie', b'0', 'Leclerc', '$2a$10$xra6oJuKaqipYL8dFwtrSuj9RJ3cyJjRL5ychLTjx//fZ9fLgE5mC', '14879550pp790'),
(5,  UTC_TIMESTAMP(), UTC_TIMESTAMP(), b'0', '8 impasse des Peupliers', 'bruno.fernandez@gmail.com', 'Bruno', b'0', 'Fernandez', '$2a$10$IHc2zYHymaoh9L9l27IyY..eqHLNpmjXW2CaUH4TKnSz8j9s5O6bO', '14238599aa650');



INSERT INTO `role` (`id_role`, `created_date`, `last_modified_date`, `role_description`, `role_name`) VALUES
(1, UTC_TIMESTAMP(), UTC_TIMESTAMP(),  'ADMIN', 'ROLE_ADMIN'),
(2, UTC_TIMESTAMP(), UTC_TIMESTAMP(),'UTILISATEUR', 'ROLE_USER');



INSERT INTO `role_utilisateur` (`id_utilisateur`, `id_role`) VALUES
(1, 1),
(1, 2),
(2, 2),
(3, 2),
(4, 2),
(5, 2);


INSERT INTO users (login, password, role) VALUES ('eduardo', '$2a$10$hAUxsMmnVO.s8JiiEK30RuPXUdj0dGZtHZ2anqFEbZCKcvm4BA5j6', 'ADMIN');

INSERT INTO address (id,street, number, neighborhood, city, state, postal_code, country, latitude,longitude)
VALUES
    (1,'R. Conselheiro Laurindo', 1162, 'Prado Velho', 'Curitiba', 'PR', '80220-030', 'Brasil',-25.434066373945207, -49.293728691491786),
    (2,'R. João Havro', 76, 'Jardim Social', 'Curitiba', 'PR', '82530-000', 'Brasil',-25.446097336109904, -49.22445009212593),
    (3,'R. Gastão Câmara 3', 756 , 'Bigorrilho', 'Curitiba', 'PR', '80710-040', 'Brasil',-25.470408874116806, -49.27129027874171),
    (4,'R. Gal. Aristides Athayde Júnior', 1192 , 'Bigorrilho', 'Curitiba', 'PR', '80730-250', 'Brasil', -25.460406283863204, -49.28054612400112),
    (5,'Av. Manoel Ribas', 2525 , 'Mercês', 'Curitiba', 'PR', '80810-001', 'Brasil',-25.43875225997751, -49.26063203268542),
    (6,'R. José de Alencar', 179 , 'São Francisco', 'Curitiba', 'PR', '80510-290', 'Brasil',-25.46036184779774, -49.27051051728632),
    (7,'R. Brasílio Itiberê', 2304 , 'Rebouças', 'Curitiba', 'PR', '80240-130', 'Brasil',-25.475967861258205, -49.24848975894475),
    (8,'Av. Silva Jardim, 1607', 1607 , 'Rebouças', 'Curitiba', 'PR', '80250-200', 'Brasil',25.45848161644655, -49.244033539358135);

INSERT INTO contacts (name, cpf, phone, address_id)
VALUES
    ('Miguel', '79059923065', '(11) 1111-1111', 1),
    ('Gael', '34009742003', '(22) 2222-2222', 2),
    ('Maria Alice', '59076615004', '(33) 3333-3333', 3),
    ('Arthur 10', '32794662023', '(10) 1010-1010', 4),
    ('Helena', '41853249017', '(10) 1010-1010', 5),
    ('Heitor', '81063447038', '(10) 1010-1010', 6),
    ('Alice', '18284907097', '(10) 1010-1010', 7),
    ('Theo', '00944809073', '(10) 1010-1010', 8);

INSERT INTO user_contacts (user_id, contact_id)
SELECT u.id, c.id
FROM users u
JOIN contacts c ON u.login = 'eduardo' AND u.role = 'ADMIN';
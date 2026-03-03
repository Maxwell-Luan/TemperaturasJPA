-- 1. Inserindo Departamentos (Ex: Setores da Fábrica)
INSERT INTO tb_departamento (nome) VALUES ('Produção de Alimentos');
INSERT INTO tb_departamento (nome) VALUES ('Câmara Fria');
INSERT INTO tb_departamento (nome) VALUES ('Fundição de Metais');

-- 2. Inserindo Sensores vinculados aos Departamentos
-- Sensor 1: Termopar na Produção (ID 1)
INSERT INTO tb_sensor (nome, tipo, departamento_id) VALUES ('Sensor-Alfa', 'Termopar', 1);
-- Sensor 2: Infravermelho na Câmara Fria (ID 2)
INSERT INTO tb_sensor (nome, tipo, departamento_id) VALUES ('Sensor-Beta', 'Infravermelho', 2);
-- Sensor 3: Sensor de Alta Precisão na Fundição (ID 3)
INSERT INTO tb_sensor (nome, tipo, departamento_id) VALUES ('Sensor-Gamma', 'Industrial', 3);

-- 3. Inserindo Leituras de Temperatura (Valores em Celsius)
-- Leituras para o Sensor 1 (Produção - Temperaturas Normais)
INSERT INTO tb_leitura (valor_celsius, momento, sensor_id) VALUES (25.5, TIMESTAMP '2026-03-01 10:00:00', 1);
INSERT INTO tb_leitura (valor_celsius, momento, sensor_id) VALUES (26.2, TIMESTAMP '2026-03-01 11:00:00', 1);

-- Leituras para o Sensor 2 (Câmara Fria - Temperaturas Baixas)
INSERT INTO tb_leitura (valor_celsius, momento, sensor_id) VALUES (-18.4, TIMESTAMP '2026-03-02 08:30:00', 2);
INSERT INTO tb_leitura (valor_celsius, momento, sensor_id) VALUES (-20.1, TIMESTAMP '2026-03-02 09:15:00', 2);

-- Leituras para o Sensor 3 (Fundição - Temperaturas Altas para testar Alertas)
INSERT INTO tb_leitura (valor_celsius, momento, sensor_id) VALUES (85.0, TIMESTAMP '2026-03-03 14:00:00', 3);
INSERT INTO tb_leitura (valor_celsius, momento, sensor_id) VALUES (92.3, TIMESTAMP '2026-03-03 15:00:00', 3);
INSERT INTO tb_leitura (valor_celsius, momento, sensor_id) VALUES (78.9, TIMESTAMP '2026-03-03 16:00:00', 3);
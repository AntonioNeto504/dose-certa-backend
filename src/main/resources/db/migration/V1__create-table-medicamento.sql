CREATE TABLE medicamento (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),  -- UUID com valor gerado automaticamente
    nome VARCHAR(255) NOT NULL,
    dosagem VARCHAR(255),
    frequencia VARCHAR(255),
    quantidade_total INT NOT NULL
);
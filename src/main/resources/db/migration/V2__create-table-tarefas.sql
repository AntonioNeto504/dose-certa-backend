CREATE TABLE tarefas (
    id UUID PRIMARY KEY,  -- Usando UUID como chave primária
    descricao VARCHAR(255) NOT NULL,  -- Descrição da tarefa
    hora TIME NOT NULL,  -- Hora em que a tarefa ocorre
    dia_semana VARCHAR(9) NOT NULL,  -- Dia da semana em que a tarefa ocorre (exemplo: 'Seg', 'Ter', ...)
    status BOOLEAN DEFAULT FALSE,  -- Status da tarefa (completa ou não)
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP  -- Data de cadastro
);

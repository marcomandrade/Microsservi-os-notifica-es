# BancoNotify — Microsserviços de Notificações Bancárias

## Como rodar localmente

Precisa ter Java 17 e Maven instalados.

### 1. Rodar o Provider

```bash
cd notification-service
mvn spring-boot:run
```

Vai subir na porta 8080.

### 2. Rodar o Consumer

Abra outro terminal:

```bash
cd notification-consumer
mvn spring-boot:run
```

Vai subir na porta 8081.

### 3. Abrir o Frontend

Só abrir o arquivo `frontend/index.html` no navegador.

---

## Endpoints

### notification-service (Provider — porta 8080)

- `POST /notificacoes` → cria uma notificação
- `GET /notificacoes` → lista todas
- `GET /notificacoes/nao-lidas` → só as não lidas
- `PUT /notificacoes/{id}/marcar-lida` → marca como lida

### notification-consumer (Consumer — porta 8081)

- `POST /consumidor/processar` → busca não lidas do provider e salva aqui
- `GET /consumidor/processadas` → lista as que já foram processadas

---

## Deploy no Railway

1. Crie dois repositórios no GitHub, um pra cada serviço
2. No Railway, crie dois projetos, um pra cada repositório
3. No projeto do Consumer, adicione a variável de ambiente:
   ```
   NOTIFICATION_SERVICE_URL = https://url-do-seu-provider.up.railway.app
   ```
4. O frontend pode ir no Vercel (só subir o index.html)

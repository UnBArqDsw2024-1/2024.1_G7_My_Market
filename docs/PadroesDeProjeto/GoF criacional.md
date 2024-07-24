# Object Pool - GoF Criacional

## 1. Introdução

O padrão Object Pool gerencia a reutilização de objetos caros de criar e destruir. Ele mantém um pool de objetos prontos para serem reutilizados, o que pode melhorar significativamente o desempenho em situações onde a criação de objetos é custosa em termos de tempo ou recursos.

## 2. Objetivo

O objetivo do padrão Object Pool é evitar o custo de criação e destruição repetida de objetos ao fornecer um pool de objetos reutilizáveis. Este padrão é particularmente útil em sistemas que requerem a criação frequente de objetos que são caros para inicializar, como conexões de banco de dados ou recursos de rede.

## 3. Implementação


### 3.1. Diagrama UML
Modelagem utilizando a ferramenta online [Miro](https://miro.com/app/board/).

<!--- 
Colocar imagem
-->


### 3.2. Código

    import java.util.LinkedList;
    import java.util.Queue;

    // Object Pool Interface
    interface Pool<T> {
        T acquire();
        void release(T obj);
    }

    // Reusable Object
    class Connection {
        private static int counter = 1;
        private int id;

        public Connection() {
            this.id = counter++;
        }

        public void connect() {
            System.out.println("Connection " + id + " established.");
        }

        public void disconnect() {
            System.out.println("Connection " + id + " terminated.");
        }

        public int getId() {
            return id;
        }
    }

    // Object Pool
    class ConnectionPool implements Pool<Connection> {
        private final Queue<Connection> availableConnections = new LinkedList<>();
        private final int MAX_POOL_SIZE = 5;

        public ConnectionPool() {
            initializePool();
        }

        private void initializePool() {
            for (int i = 0; i < MAX_POOL_SIZE; i++) {
                availableConnections.add(new Connection());
            }
        }

        @Override
        public Connection acquire() {
            if (availableConnections.isEmpty()) {
                System.out.println("No available connections. Please wait...");
                return null;
            }
            Connection conn = availableConnections.poll();
            conn.connect();
            return conn;
        }

        @Override
        public void release(Connection conn) {
            conn.disconnect();
            availableConnections.offer(conn);
        }
    }

    // Uso do padrão
    public class Main {
        public static void main(String[] args) {
            ConnectionPool pool = new ConnectionPool();

            Connection conn1 = pool.acquire();
            Connection conn2 = pool.acquire();

            pool.release(conn1);
            pool.release(conn2);

            Connection conn3 = pool.acquire();
        }
    }


## Referências

> **Arquitetura e Desenho de Software - Aula GoFs Comportamentais**. Material de apoio em slides. Milene Serrano.
## Versionamento

| Versão | Alteração |  Responsável  | Revisor | Data de realização | Data de revisão |
| :------: | :---: | :-----: | :----: | :----: | :-----: |
| 1.0 | Criação do documento | [Guilherme Soares](https://github.com/GuilhermeSoaress) / [Miguel de Frias](https://github.com/migueldefrias) | [Guilherme Basílio](https://github.com/GuilhermeBES) | 22/07/2024 | 22/07/2024 |
| 1.1 | Adição do Código | [Miguel de Frias](https://github.com/migueldefrias) | [Guilherme Basílio](https://github.com/GuilhermeBES) e [Guilherme Soares](https://github.com/GuilhermeSoaress)| 23/07/2024 | 24/07/2024 |
| 1.2 | Adição do Diagrama UML | [Miguel de Frias](https://github.com/migueldefrias) | [Guilherme Basílio](https://github.com/GuilhermeBES) e [Guilherme Soares](https://github.com/GuilhermeSoaress)| 23/07/2024 | 24/07/2024 |
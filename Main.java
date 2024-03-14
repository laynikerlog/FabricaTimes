// Product
class CamisaEsportiva {
    private String time;
    private String historia;

    public CamisaEsportiva(String time, String historia) {
        this.time = time;
        this.historia = historia;
    }

    public void exibirDados() {
        System.out.println("Camisa do time: " + time);
        System.out.println("História do time: " + historia);
    }
}

// Concrete Product
class Time {
    private String nome;
    private String historia;

    public Time(String nome, String historia) {
        this.setNome(nome);
        this.historia = historia;
    }

    public String getNome() {
        return nome;

    }

    public void setNome(String nome) {
        this.nome = nome;

    }

    public String obterHistoria() {
        return historia;
    }
}

// Creator (Factory Method)
interface FabricaEsportiva {
    CamisaEsportiva criarCamisa();
}

// Concrete Creators
class FabricaNike implements FabricaEsportiva {
    @Override
    public CamisaEsportiva criarCamisa() {
        Time time = new Time("Brasil", "O Brasil é conhecido como a seleção pentacampeã do mundo.");
        return new CamisaEsportiva(time.getNome(), time.obterHistoria());
    }
}

class FabricaAdidas implements FabricaEsportiva {
    @Override
    public CamisaEsportiva criarCamisa() {
        Time time = new Time("Flamengo",
                "O Flamengo é um dos clubes de futebol mais populares do Brasil, com uma grande história de sucesso nacional e internacional.");
        return new CamisaEsportiva(time.getNome(), time.obterHistoria());
    }
}

class FabricaPuma implements FabricaEsportiva {
    @Override
    public CamisaEsportiva criarCamisa() {
        Time time = new Time("Botafogo",
                "O Botafogo é um clube de futebol tradicional do Rio de Janeiro, com uma história rica e várias conquistas importantes ao longo dos anos.");
        return new CamisaEsportiva(time.getNome(), time.obterHistoria());
    }
}

class FabricaUmbro implements FabricaEsportiva {
    @Override
    public CamisaEsportiva criarCamisa() {
        Time time = new Time("Fluminense",
                "O Fluminense é um dos clubes mais antigos e tradicionais do futebol brasileiro, com uma grande base de torcedores e uma história de sucesso no esporte.");
        return new CamisaEsportiva(time.getNome(), time.obterHistoria());
    }
}

class FabricaKappa implements FabricaEsportiva {
    @Override
    public CamisaEsportiva criarCamisa() {
        Time time = new Time("Vasco",
                "O Vasco da Gama é um clube de futebol conhecido por sua rica história e tradição, tendo conquistado vários títulos nacionais e internacionais ao longo dos anos.");
        return new CamisaEsportiva(time.getNome(), time.obterHistoria());
    }
}

public class Main {
    public static void main(String[] args) {
        FabricaEsportiva[] fabricas = {
                new FabricaNike(),
                new FabricaAdidas(),
                new FabricaPuma(),
                new FabricaUmbro(),
                new FabricaKappa()
        };

        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma fábrica esportiva ou digite 'sair' para encerrar:");
            for (FabricaEsportiva fabrica : fabricas) {
                System.out.println(fabrica.getClass().getSimpleName().replace("Fabrica", ""));
            }
            System.out.print("Digite o nome da fábrica: ");
            String escolhaFabrica = scanner.nextLine();

            if (escolhaFabrica.equalsIgnoreCase("sair")) {
                break;
            }

            FabricaEsportiva fabricaEsportiva = null;
            for (FabricaEsportiva fabrica : fabricas) {
                if (fabrica.getClass().getSimpleName().replace("Fabrica", "").equalsIgnoreCase(escolhaFabrica)) {
                    fabricaEsportiva = fabrica;
                    break;
                }
            }

            if (fabricaEsportiva != null) {
                CamisaEsportiva camisa = fabricaEsportiva.criarCamisa();
                camisa.exibirDados();
                System.out.println();
            } else {
                System.out.println("Fábrica não encontrada. Por favor, escolha uma das opções disponíveis.");
            }
        }
    }
}

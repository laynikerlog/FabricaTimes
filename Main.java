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

interface FabricaEsportiva {
    CamisaEsportiva criarCamisa();
}

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
            System.out.println("Escolha um time ou digite 'sair' para encerrar:");
            System.out.println("Brasil");
            System.out.println("Flamengo");
            System.out.println("Botafogo");
            System.out.println("Fluminense");
            System.out.println("Vasco");
            System.out.print("Digite o nome do time: ");
            String escolhaTime = scanner.nextLine();

            if (escolhaTime.equalsIgnoreCase("sair")) {
                break;
            }

            String historiaTime = obterHistoriaTime(escolhaTime);
            if (historiaTime != null) {
                System.out.println("História do time " + escolhaTime + ": " + historiaTime);

                FabricaEsportiva fabricaEsportiva = obterFabricaEsportivaPeloTime(fabricas, escolhaTime);
                if (fabricaEsportiva != null) {
                    System.out.println("Fábrica correspondente: "
                            + fabricaEsportiva.getClass().getSimpleName().replace("Fabrica", ""));
                    String historiaFabrica = obterHistoriaFabrica(
                            fabricaEsportiva.getClass().getSimpleName().replace("Fabrica", ""));
                    System.out.println("História da fábrica: " + historiaFabrica);
                } else {
                    System.out.println("Fábrica não encontrada para o time " + escolhaTime);
                }
                System.out.println();
            } else {
                System.out.println("Time não encontrado. Por favor, escolha um dos times disponíveis.");
            }
        }
    }

    private static String obterHistoriaTime(String nomeTime) {
        switch (nomeTime.toLowerCase()) {
            case "brasil":
                return "O Brasil é conhecido como a seleção pentacampeã do mundo.";
            case "flamengo":
                return "O Flamengo é um dos clubes de futebol mais populares do Brasil, com uma grande história de sucesso nacional e internacional.";
            case "botafogo":
                return "O Botafogo é um clube de futebol tradicional do Rio de Janeiro, com uma história rica e várias conquistas importantes ao longo dos anos.";
            case "fluminense":
                return "O Fluminense é um dos clubes mais antigos e tradicionais do futebol brasileiro, com uma grande base de torcedores e uma história de sucesso no esporte.";
            case "vasco":
                return "O Vasco da Gama é um clube de futebol conhecido por sua rica história e tradição, tendo conquistado vários títulos nacionais e internacionais ao longo dos anos.";
            default:
                return null;
        }
    }

    private static FabricaEsportiva obterFabricaEsportivaPeloTime(FabricaEsportiva[] fabricas, String nomeTime) {
        switch (nomeTime.toLowerCase()) {
            case "brasil":
                return fabricas[0]; // Nike
            case "flamengo":
                return fabricas[1]; // Adidas
            case "botafogo":
                return fabricas[2]; // Puma
            case "fluminense":
                return fabricas[3]; // Umbro
            case "vasco":
                return fabricas[4]; // Kappa
            default:
                return null;
        }
    }

    private static String obterHistoriaFabrica(String nomeFabrica) {
        switch (nomeFabrica.toLowerCase()) {
            case "nike":
                return "A Nike é uma das maiores empresas de artigos esportivos do mundo, conhecida por seus produtos de alta qualidade e por patrocinar diversos atletas e equipes ao redor do globo.";
            case "adidas":
                return "A Adidas é uma das marcas esportivas mais reconhecidas do mundo, famosa por suas inovações tecnológicas e por patrocinar algumas das principais equipes e eventos esportivos.";
            case "puma":
                return "A Puma é uma marca esportiva de renome mundial, famosa por suas roupas e calçados esportivos de alta qualidade, bem como por sua presença em diversos esportes e eventos.";
            case "umbro":
                return "A Umbro é uma marca de artigos esportivos conhecida por suas roupas e equipamentos de futebol de alta qualidade, sendo utilizada por várias equipes profissionais em todo o mundo.";
            case "kappa":
                return "A Kappa é uma marca italiana de artigos esportivos, famosa por suas roupas e acessórios esportivos de estilo único e por seu apoio a diversas equipes e atletas em todo o mundo.";
            default:
                return null;
        }
    }
}

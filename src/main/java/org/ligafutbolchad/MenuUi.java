package org.ligafutbolchad;
import java.util.Scanner;

public class MenuUi {
    final private LigaChadService liga;
    final private EstadisticaService estadisticas;
    final private CsvService csvService;

    public MenuUi() {
        this.liga = new LigaChadService();
        this.estadisticas = new EstadisticaService(liga);
        this.csvService = new CsvService();
    }

    Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Gestionar Equipos");
            System.out.println("2. Gestionar Jugadores");
            System.out.println("3. Registrar Partido");
            System.out.println("4. Estadísticas");
            System.out.println("5. Importar/Exportar datos");
            System.out.println("6. Salir");
            System.out.println("\nOpcion: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    menuEquipos();
                    break;
                case 2:
                    menuJugadores();
                    break;
                case 3:
                    menuPartidos();
                    break;
                case 4:
                    menuEstadisticas();
                    break;
                case 5:
                    menuExportar();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
        scanner.close();
    }

    private void menuEquipos() {
        int opcion;
        do {
            System.out.println("\n===== GESTIONAR EQUIPOS =====");
            System.out.println("1. Crear equipo");
            System.out.println("2. Listar equipos");
            System.out.println("3. Listar jugadores de un equipo");
            System.out.println("4. Volver");
            System.out.println("\nOpcion: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del equipo: ");
                    String nombre = scanner.nextLine();
                    liga.crearEquipo(nombre);
                    System.out.println("Equipo creado correctamente.");
                    break;
                case 2:
                    System.out.println("Lista de equipos:");
                    for (Equipo equipo : liga.getEquipos()) {
                        System.out.println("- " + equipo.getNombre());
                    }
                    break;
                case 3:
                    System.out.print("Nombre del equipo a listar: ");
                    String nombreEquipo = scanner.nextLine();

                    for (Equipo equipo : liga.getEquipos()) {
                        if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {
                            System.out.println("Listado de jugadores de " + equipo.getNombre() + ":");
                            liga.listarJugadores(equipo);
                            break;
                        }
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);
    }

    private void menuJugadores() {
        int opcion;
        do {
            System.out.println("\n===== GESTIONAR JUGADORES =====");
            System.out.println("1. Agregar jugador titular");
            System.out.println("2. Agregar jugador suplente");
            System.out.println("3. Volver");
            opcion = Integer.parseInt(scanner.nextLine());

            String equipoDestino = null;
            switch (opcion) {
                case 1:
                    System.out.print("Equipo de destino: ");
                    equipoDestino = scanner.nextLine();
                    for (Equipo equipo : liga.getEquipos()) {
                        if (equipo.getNombre().equalsIgnoreCase(equipoDestino)) {
                            System.out.println("Ingrese nombre del jugador: ");
                            String nombre = scanner.nextLine();

                            System.out.print("Ingrese edad del jugador: ");
                            int edad = Integer.parseInt(scanner.nextLine());

                            System.out.print("Ingrese minutos jugados: ");
                            int minutos = Integer.parseInt(scanner.nextLine());

                            JugadorTitular jt = new JugadorTitular(nombre, edad, minutos);
                            liga.registrarJugador(jt, equipo);
                        }
                    }
                    break;
                case 2:
                    System.out.print("Equipo de destino: ");
                    equipoDestino = scanner.nextLine();
                    for (Equipo equipo : liga.getEquipos()) {
                        if (equipo.getNombre().equalsIgnoreCase(equipoDestino)) {
                            System.out.println("Ingrese nombre del jugador: ");
                            String nombre = scanner.nextLine();

                            System.out.print("Ingrese edad del jugador: ");
                            int edad = Integer.parseInt(scanner.nextLine());

                            System.out.print("Ingrese partidos ingresados: ");
                            int partidosIngresados = Integer.parseInt(scanner.nextLine());

                            JugadorSuplente js = new JugadorSuplente(nombre, edad, partidosIngresados);
                            liga.registrarJugador(js, equipo);
                        }
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción inválida.");
                }
        } while (opcion != 3);

    }

    private void menuPartidos(){
        System.out.println("\n===== GESTIONAR PARTIDOS =====");
        System.out.println("Implementación en curso.");
    }

    private void menuEstadisticas() {
        System.out.println("\n===== ESTADÍSTICAS =====");
        estadisticas.goleadorLiga();
        estadisticas.promedioGolesEquipo();
        estadisticas.rankingEquiposPorGoles();
        estadisticas.suplentesNuncaIngresados();
        estadisticas.titularConMasMinutos();
    }

    private void menuExportar() {
        System.out.print("Nombre del equipo a exportar: ");
        String nombreEquipo = scanner.nextLine();
        for (Equipo equipo : liga.getEquipos()) {
            if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {
                csvService.exportarDatosEquipo(equipo);
                return;
            }
        }
        System.out.println("Equipo no encontrado.");
    }
}
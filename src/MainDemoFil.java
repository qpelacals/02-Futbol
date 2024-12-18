public class MainDemoFil {
    public static void main(String[] args) {
        // Captura el fil actual en execució
        Thread currentThread = Thread.currentThread();

        // Mostra les propietats del fil
        System.out.println("MainDemoFil.main:");
        System.out.println("Prioritat -> " + currentThread.getPriority() + ", Nom -> " + currentThread.getName());
        System.out.println("toString() -> " + currentThread);
    }
}
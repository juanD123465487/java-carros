class Vehiculo {
    private String marca;
    private String modelo;
    private int velocidadActual;
    private int velocidadMaxima;
    
    public Vehiculo(String marca, String modelo, int velocidadMaxima) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadActual = 0;
        this.velocidadMaxima = velocidadMaxima;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public int getVelocidadActual() {
        return velocidadActual;
    }
    
    protected void setVelocidadActual(int velocidadActual) {
        if (velocidadActual >= 0 && velocidadActual <= velocidadMaxima) {
            this.velocidadActual = velocidadActual;
        }
    }
    
    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }
    
    public void mostrarInformacion() {
        System.out.println("=== Información del Vehículo ===");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Velocidad actual: " + velocidadActual + " km/h");
        System.out.println("Velocidad máxima: " + velocidadMaxima + " km/h");
    }
    
    public void acelerar() {
        if (velocidadActual < velocidadMaxima) {
            velocidadActual += 10;
            System.out.println("Vehículo acelerando... Velocidad actual: " + velocidadActual + " km/h");
        } else {
            System.out.println("El vehículo ya está a velocidad máxima!");
        }
    }
}

class Auto extends Vehiculo {
    private int numeroPuertas;
    
    public Auto(String marca, String modelo, int velocidadMaxima, int numeroPuertas) {
        super(marca, modelo, velocidadMaxima);
        this.numeroPuertas = numeroPuertas;
    }
    
    public int getNumeroPuertas() {
        return numeroPuertas;
    }
    
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Número de puertas: " + numeroPuertas);
        System.out.println("Tipo: Automóvil");
    }
    
    @Override
    public void acelerar() {
        if (getVelocidadActual() < getVelocidadMaxima()) {
            setVelocidadActual(getVelocidadActual() + 15);
            System.out.println("🚗 Auto acelerando suavemente... Velocidad actual: " + 
                             getVelocidadActual() + " km/h");
        } else {
            System.out.println("🚗 El auto ya está a velocidad máxima!");
        }
    }
}

class Motocicleta extends Vehiculo {
    private int cilindraje;
    
    public Motocicleta(String marca, String modelo, int velocidadMaxima, int cilindraje) {
        super(marca, modelo, velocidadMaxima);
        this.cilindraje = cilindraje;
    }
    
    public int getCilindraje() {
        return cilindraje;
    }
    
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Cilindraje: " + cilindraje + "cc");
        System.out.println("Tipo: Motocicleta");
    }
    
    @Override
    public void acelerar() {
        if (getVelocidadActual() < getVelocidadMaxima()) {
            setVelocidadActual(getVelocidadActual() + 25);
            System.out.println("🏍️  Motocicleta acelerando rápidamente... Velocidad actual: " + 
                             getVelocidadActual() + " km/h");
        } else {
            System.out.println("🏍️  La motocicleta ya está a velocidad máxima!");
        }
    }
}

class Camion extends Vehiculo {
    private int capacidadCarga;
    
    public Camion(String marca, String modelo, int velocidadMaxima, int capacidadCarga) {
        super(marca, modelo, velocidadMaxima);
        this.capacidadCarga = capacidadCarga;
    }
    
    public int getCapacidadCarga() {
        return capacidadCarga;
    }
    
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Capacidad de carga: " + capacidadCarga + " toneladas");
        System.out.println("Tipo: Camión");
    }
    
    @Override
    public void acelerar() {
        if (getVelocidadActual() < getVelocidadMaxima()) {
            setVelocidadActual(getVelocidadActual() + 8);
            System.out.println("🚚 Camión acelerando lentamente... Velocidad actual: " + 
                             getVelocidadActual() + " km/h");
        } else {
            System.out.println("🚚 El camión ya está a velocidad máxima!");
        }
    }
}


public class SistemaVehiculos {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE VEHÍCULOS ===\n");
        
        
        Vehiculo vehiculoBase = new Vehiculo("Genérico", "Modelo Base", 120);
        Auto auto = new Auto("Toyota", "Corolla", 180, 4);
        Motocicleta moto = new Motocicleta("Yamaha", "YZF-R1", 300, 998);
        Camion camion = new Camion("Volvo", "FH16", 90, 40);
        
       
        Vehiculo[] vehiculos = {vehiculoBase, auto, moto, camion};
        
       
        System.out.println("📋 INFORMACIÓN DE LOS VEHÍCULOS:");
        for (int i = 0; i < vehiculos.length; i++) {
            System.out.println("\n--- Vehículo " + (i + 1) + " ---");
            vehiculos[i].mostrarInformacion();
        }
        
        
        System.out.println("\n\n🚀 DEMOSTRANDO POLIMORFISMO - ACELERACIÓN:");
        System.out.println("=".repeat(50));
        
        for (int i = 0; i < vehiculos.length; i++) {
            System.out.println("\nVehículo " + (i + 1) + " (" + 
                             vehiculos[i].getMarca() + " " + vehiculos[i].getModelo() + "):");
            
            
            for (int j = 0; j < 3; j++) {
                vehiculos[i].acelerar();
            }
            System.out.println("-".repeat(30));
        }
        
        
        System.out.println("\n\n🔄 SEGUNDA RONDA DE ACELERACIÓN:");
        System.out.println("=".repeat(50));
        
        for (Vehiculo v : vehiculos) {
            System.out.println("\n" + v.getClass().getSimpleName() + " - " + 
                             v.getMarca() + " " + v.getModelo() + ":");
            v.acelerar();
            v.acelerar();
        }
        
        System.out.println("\n\n✅ Demostración completada!");
        System.out.println("Se observa cómo cada tipo de vehículo tiene un comportamiento diferente al acelerar:");
        System.out.println("• Vehículo base: +10 km/h");
        System.out.println("• Auto: +15 km/h (aceleración suave)");
        System.out.println("• Motocicleta: +25 km/h (aceleración rápida)");
        System.out.println("• Camión: +8 km/h (aceleración lenta)");
    }
}
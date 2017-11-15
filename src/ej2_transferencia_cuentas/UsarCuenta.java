/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej2_transferencia_cuentas;

/**
 *
 * @author dam203
 */
public class UsarCuenta {
    public static void main(String[] args) throws InterruptedException {
        final Cuenta c1, c2;
        Thread t1, t2;

        long start_time = System.currentTimeMillis();

        c1 = new Cuenta(1, 1);
        c2 = new Cuenta(2, 1);

        t1 = new Thread(new Transferencia(c1, c2));
        t2 = new Thread(new Transferencia(c2, c1));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long end_time = System.currentTimeMillis();
        int total_time = (int) (end_time - start_time);
        System.out.format("29BPDJ - El saldo de c1 es: %f\n", c1.balance);
        System.out.format("29BPDJ - El saldo de c2 es: %f\n", c2.balance);
        System.out.format("29BPDJ - La diferencia de saldo es: %f\n", c1.balance - c2.balance);       
        System.out.println("29BPDJ - Time:" + total_time + " ms");
    }
}

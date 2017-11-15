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
class Cuenta {
    double balance;
    int id;

    Cuenta(int id, double balance) {
        this.id = id;
        this.balance=balance;
    }

    private void withdraw(double amount) {
        balance -= amount;
    }

    private void deposit(double amount) {
        balance += amount;
    }

     void transfer(Cuenta from, Cuenta to, double amount) {
        Cuenta primeraCuenta, segundaCuenta;
        if (from.id < to.id) {
            primeraCuenta = from;
            segundaCuenta = to;
        } else {
            primeraCuenta = to;
            segundaCuenta = from;
        }

        synchronized (primeraCuenta) {
            synchronized (segundaCuenta) {
                from.withdraw(amount);
                to.deposit(amount);
            }
        }
    }

}

package InterfaceAlphaDB;

import conection.ConexaoAlphaDB;

public class InterfaceDB {

    public static void main(String[] args) {
        ConexaoAlphaDB c = new ConexaoAlphaDB();
        c.getConexao();
    }
}
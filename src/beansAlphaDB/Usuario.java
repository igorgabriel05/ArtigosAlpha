package beansAlphaDB;

public class Usuario {
    private int id;
    private String usuario;
    private String senha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String toString() {
        return this.usuario;
    }
    
    public boolean equals(Object objeto) {
        Usuario u = (Usuario) objeto;
        if(this.usuario == u.getUsuario()) {
            return true;
        } else {
            return false;
        }
    }
}

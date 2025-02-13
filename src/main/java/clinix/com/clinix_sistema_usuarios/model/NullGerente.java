package clinix.com.clinix_sistema_usuarios.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NullGerente extends Gerente{
    @Override
    public boolean isNull(){
        return true;   
    }
}

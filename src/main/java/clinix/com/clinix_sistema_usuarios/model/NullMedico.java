package clinix.com.clinix_sistema_usuarios.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NullMedico extends Medico {

    @Override
    public boolean isNull(){
        return true;
    }

}

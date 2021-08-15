package br.com.eniac.eniac.modulos.tratamentos;

import br.com.eniac.eniac.modulos.enums.StatusDiabetes;

public class  LogicaDiabetes {

    public static final int glicemiaJejumNormal = 99;
    public static final int glicemiaJejumAlteradoInicial = 100;
    public static final int glicemiaJejumAlteradoFinal = 125;

      static  StatusDiabetes setGlicemia(boolean jejum, int intGlicemia) {

            if(jejum && intGlicemia <= glicemiaJejumNormal) {
                return StatusDiabetes.GLICEMIA_NORMAL;
            }
            else if(jejum && intGlicemia >=
                    glicemiaJejumAlteradoInicial &
                    intGlicemia <= glicemiaJejumAlteradoFinal) {
                return StatusDiabetes.GLICEMIA_ALTERADA;
            }else if(jejum && intGlicemia >=
                    glicemiaJejumAlteradoInicial) {
                return StatusDiabetes.DIABETES;
            }
            else if(!jejum && intGlicemia <= 200) {
                return StatusDiabetes.GLICEMIA_NORMAL;
            }
            else if(!jejum && intGlicemia > 200) {
                return StatusDiabetes.DIABETES;
            }
            throw new NullPointerException("O Campo glicemia deve ser um inteiro e deve ser preenchido");
    }
}

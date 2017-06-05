
public class CalculoDistancia {
	private Double fator = 0.0; //fX
	
	public CalculoDistancia(Double fator) {
		this.fator = fator;
	}
	public CalculoDistancia(){}
	
    /**
     * @param distancia do objeto a camera
     * @param fE distancia do pixel esquerdo
     * @param fD distancia do pixel direito
     */
	public void CalculoFator(Double distancia, Integer fE, Integer fD){
		fator = (fE - fD) * distancia;
	}
    /**
     * @param fE distancia do pixel esquerdo
     * @param fD distancia do pixel direito
     * @return retorna a distancia do objeto
     */
	public Double getDistancia(Integer fE, Integer fD){
		return fator/(fE-fD);
	}
    /**
     *@return retorna o fator
     */
	public Double getFator(){
		return fator;
	}
    /**
     *@param seta o fator
     */
	public void setFator(Double fator){
		this.fator = fator;
	}
}

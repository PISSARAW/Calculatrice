public final class Rationnel implements Nombre{
    private final Long num;
    private final Long den;

    private Rationnel(Long num, Long den) {
        this.num = num;
        this.den = den;
    }

    public static Rationnel faire(long n, long d){
        try{
            Rationnel r=null;
            if(d!=0.0&&Rationnel.coprem(n, d)==1){
                if(d<0){
                    d=d+(-d*2);
                    n=n-(n*2);
                }
                r = new Rationnel(n,d);
                return r;
            }
            else
                throw new Exception();
        }
        catch (Exception e){
            System.out.println(" Nombre Rationnel impossible");
            System.out.println(n + " n | d "+ d);
        }
        return null;
    }

    public static long coprem(long a, long b){
        a=(a>0)?a:-a;
        b=(b>0)?b:-b;
        if (a==0)
            return b;
        return coprem(b%a,a);
    }

    @Override
    public String toString() {
        return ""+num+"/"+den;
    }

    public long getNum() {
        return num;
    }

    public long getDen() {
        return den;
    }

    /**
     * Additione deux nombres
     *
     * @param n
     * @return
     */
    @Override
    public Nombre plus(Nombre n) {
    	
             if ((n instanceof Entier)||( n instanceof Flottant)) {
                 if(n instanceof Flottant)
                 {
                	 return (Flottant.faire(((Flottant) n).getX() + (double)((double)this.getNum()/(double)this.getDen())));
                 }
                 else
                 {
                	return  (Rationnel.faire(this.getNum()+(this.getDen()*(((Entier) n).getX())),this.getDen())); 
                 }
             }
             System.out.print("Operation incompatible");
    	return null;
    }
    

    /**
     * Soustrait deux nombres
     *
     * @param n
     * @return
     */
    @Override
    public Nombre moins(Nombre n) {
        return this.plus(n.oppose());
    }

    /**
     * Multiplie deux nombres
     *
     * @param n
     * @return
     */
    @Override
    public Nombre fois(Nombre n) {
        if (n instanceof Flottant)
            return Flottant.faire((this.num*((Flottant) n).getX())/(this.den*1));
        else if (n instanceof Entier)
            return Rationnel.faire(this.num*((Entier) n).getX(), this.den);
        return Rationnel.faire(num*((Rationnel) n).getNum(), den*((Rationnel) n).getDen());
    }

    /**
     * Divise deux nombres
     *
     * @param n
     * @return
     */
    @Override
    public Nombre quotient(Nombre n) {
        return this.fois(n.inverse());
    }

    /**
     * Inverse in nombre
     *
     * @return
     */
    @Override
    public Nombre inverse() {
        return Rationnel.faire(this.getDen(),this.getNum());
    }
    
    	public Nombre oppose() {
		
		return Rationnel.faire(- getNum(),getDen());
	}
}

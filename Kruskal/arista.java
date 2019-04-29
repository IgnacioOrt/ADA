class arista
{
	int vertice1;
	int vertice2;
	int peso;
	public arista(int v1, int v2, int p){
		vertice1 = v1;
		vertice2 = v2;
		peso = p;
	}
	public void escribeArista()
	{
		System.out.println("Vertice 1: " + vertice1 + " Vertice 2: " + vertice2 + " Peso: " + peso);
	}
}
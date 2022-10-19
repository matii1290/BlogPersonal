export class Noticias {
    id?: number;
    nombreN: string;
    descripcionN: string;

    constructor(nombreN: string, descripcionN: string){

    this.nombreN = nombreN;
    this.descripcionN = descripcionN;
}
}
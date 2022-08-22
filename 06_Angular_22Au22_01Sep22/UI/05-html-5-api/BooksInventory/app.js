class Book {
    constructor(bcode,title,price,publishDate){
        this.bcode=bcode;
        this.title=title;
        this.price=price;
        this.publishDate=publishDate;
    }
}

class BookService {
    constructor(){
        this.books = [
            new Book(1,"Let Us C",456.90,new Date("2020-02-02"))
        ];        
    }
    
    addBook(book){

    }
    
    modifyBook(book) {
    
    }

    getAllBooks(){

    }

    getBookById(bcode){

    }

    deleteBookById(bcode){

    }
}

const loadBooks = event => {

}

const addButtonClicked = event => {

}

const deleteButtonClicked = event => {

}

const saveButtonClicked = event => {

}
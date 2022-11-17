const App = {
    data() {
        return { 
            // counter: 0,
            title: 'Список задач',
            placeholderString: 'Введите название задачи',
            inputValue: '',
            notes: ['Заметка 1', 'Pfvtnrf']
        }
    },
    methods: {
        inputChangeHandler(event){
            this.inputValue = event.target.value 
        },
        addNewNote(){
            if (this.inputValue !== ''){
                this.notes.push(this.inputValue)
                this.inputValue =''
            }
            
        },
        inputKeyPress(event){
            if (event.key === 'Enter') {
                this.addNewNote()
            }
        },
        removeNote(idx){
            this.notes.splice(idx,1)
        }
    }    
}
 

Vue.createApp(App).mount('#app')

const App = {
    data() {
        return { 
            counter: 0,
            title: 'Список задач',
            placeholderString: 'Введите название задачи',
            inputValue: '',
            notes: ['Заметка 1', 'Pfvtnrf']
        }
    },
    metods: {
        inputChangeHandler(event){
            this.inputValue = event.target.value 
        },
        addNewNote(){
            this.notes.push(this.inputValue)
            this.inputValue =''
        }
    }
    
}
 

Vue.createApp(App).mount('#app')

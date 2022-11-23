Vue.component('tasks', {
    props:['data'],
    methods:{

    },
    template:`
    <div class="task">
        <div>
            <h3 class="task__title"></h3>
            <p class="task__desc"></p>
        </div>
        <button class="task__done">✅</button>
    </div>
    `
})
var vue  = new Vue({
    el:'#app',
    data{
        
    },
    methods: {
        add(){

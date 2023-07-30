import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import { quillEditor } from 'vue3-quill'

createApp(App).use(store).use(router).use(quillEditor).mount('#app')

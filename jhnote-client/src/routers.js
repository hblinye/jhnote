import Home from './components/Home.vue';
import UserEditor from './components/UserEditor.vue';
import CompanyEditor from './components/CompanyEditor.vue';

const routers = [
    {
        path: '/',
        component: Home,
        children: [
            {
                path: 'user',
                component: UserEditor
            },
            {
                path: 'company',
                component: CompanyEditor
            }
        ]
    }
]
export default routers
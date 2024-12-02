// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router';
import HomeDemo from '../views/HomeDemo.vue';
import AboutDemo from '../views/AboutDemo.vue';
import ContactDemo from '../views/ContactDemo.vue';
import StudentList from '../components/StudentList.vue';
import CourseList from '../components/CourseList.vue';
import LoginView from '../components/LoginView.vue';
import BookList from "@/components/BookList.vue";
import CustomerList from "@/components/CustomerList.vue";

const routes = [
    {
        path: '/',
        redirect: '/login'
    },
    {
        path: '/login',
        component: LoginView
    },
    {
        path: '/home',
        name: 'HomeDemo',
        component: HomeDemo,
        meta: { requiresAuth: true }
    },
    {
        path: '/about',
        name: 'AboutDemo',
        component: AboutDemo,
        meta: { requiresAuth: true }
    },
    {
        path: '/studentList',
        name: 'StudentList',
        component: StudentList,
        meta: { requiresAuth: true }
    }, {
        path: '/courseList',
        name: 'CourseList',
        component: CourseList,
        meta: { requiresAuth: true }
    }, {
        path: '/bookList',
        name: 'BookList',
        component: BookList,
        meta: { requiresAuth: true }
    }, {
        path: '/customerList',
        name: 'CustomerList',
        component: CustomerList,
        meta: { requiresAuth: true }
    },
    {
        path: '/contact',
        name: 'ContactDemo',
        component: ContactDemo,
        meta: { requiresAuth: true }
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

router.beforeEach((to, from, next) => {
    const requiresAuth = to.matched.some(record => record.meta.requiresAuth);
    const isLoggedIn = localStorage.getItem('userToken') !== null;

    if (requiresAuth && !isLoggedIn) {
        next('/login'); // 如果需要认证且未登录，重定向到登录页面
    } else {
        next(); // 否则继续导航
    }
});

export default router;
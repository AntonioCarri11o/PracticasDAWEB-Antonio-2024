<template>
    <div>
        <h1>Login</h1>
        <button @click="login('admin')">Login as Admin</button>
        <button @click="login('editor')">Login as Editor</button>
        <button @click="login('viewer')">Login as Viewer</button>
    </div>
</template>
<script>
import { jwtDecode } from 'jwt-decode';
export default {
    name: 'Login',
    methods: {
        login(role) {
            let token;
            switch (role) {
                case 'admin':
                    token = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJyb2xlIjoiYWRtaW4ifQ.UHnffynBjuE3dcwEUyqldVbN-5QzMT-oiyXqkRbWJOI';
                    break;
                case 'editor':
                    token = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJyb2xlIjoiZWRpdG9yIn0.O_uqVbz-BOfRRRmyY5bMX0aEg_YmWESE_okCflsM_JA';
                    break;
                case 'viewer':
                    token = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJyb2xlIjoidmlld2VyIn0.uoNjQeybe0q6NSVYguZLJCpOg7ftV7b_TW76Cp-3euc';
                    break;
                default:
                    break;
            }
            localStorage.setItem('token', token);

            const decoded = jwtDecode(token);
            this.redirectUser(decoded.role);
        },        
        redirectUser(role) {
            if (role === 'admin') {
                this.$router.push('/admin');
            } else if (role === 'editor') {
                this.$router.push('/editor');
            } else if (role === 'viewer') {
                this.$router.push('/viewer');
            }
        }
    },
    data() {
        return {

        }
    }
}
</script>
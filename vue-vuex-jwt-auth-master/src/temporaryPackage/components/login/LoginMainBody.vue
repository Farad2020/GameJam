<template>
  <div class="row m-0">
    <div class="col-8 offset-2">
      <h3 class="m-0">Log In</h3>
    </div>
  </div>
  <hr />
  <div class="container">
    <div class="row my_min_h h-100 d-flex align-items-center">
      <div class="col-6 offset-3">
        <form @submit.prevent="handleLogin">
          <div class="form-group pt-3">
            <label>Email address</label>
            <input v-model="user.email"
                   aria-describedby="emailHelp"
                   class="form-control"
                   placeholder="Enter email"
                   type="email"
            />
          </div>
          <div class="form-group pt-3">
            <label>Password</label>
            <input
              v-model="user.password"
              class="form-control"
              placeholder="Password"
              type="password"
            />
          </div>
          <div class="d-flex justify-content-end pt-3">
            <button class="btn btn-primary btn-bg-purple align-self-right" type="submit">Submit</button>
          </div>
        </form>
        <div class="text-center">
          <p>New to this site? You can register <a class="my_dark_text_link" href="/#/registration">here</a></p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

const instSec = axios.create({
  baseURL: "http://localhost:8081/",
  authorization: `Bearer ${localStorage.getItem("token")}`
});

export default {
  name: "LoginMainBody",
  data() {
    return {
      user: { email: "", password: "test" },
      loading: false,
      message: ""
    };
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    }
  },
  // created() {
  //   if (this.loggedIn) {
  //     this.$router.push('/profile');
  //   }
  // },
  methods: {
    handleLogin() {
      this.loading = true;
      // alert(this.user.email + this.user.password)
      if (this.user.email && this.user.password) {
        const headers = {
          "Access-Control-Allow-Origin": "http://localhost:8080",
          "Content-Type": "application/json"
        };


        instSec.post("/auth", this.user, { headers }).then(
          response => {
            if (response.data.jwtToken) {
              localStorage.setItem("token", response.data.jwtToken);
              alert(localStorage.token);
              // localStorage.token = response.data.jwtToken;
            }

            return response.data;
          },
          error => {
            this.loading = false;
            this.message =
              (error.response && error.response.data) ||
              error.message ||
              error.toString();
          }
        );
      }
    }
  }
};

</script>

<style scoped>

.btn-bg-purple {
  background-color: #6200ee;
  border-color: #6200ee;
}

.btn-bg-purple:hover {
  background-color: #7517fa;
  border-color: #7517fa;
}

h3 {
  font-family: 'Courgette', cursive;
  font-weight: bold;
}

.my_dark_text_link {
  color: #000;
}

.my_dark_text_link:hover {
  color: #2c3e50;
}
</style>
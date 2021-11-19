import React from "react";
import history from "../history";
import axios from "axios";

class Login extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
     
      username: "",
      password: "",
    };
  }

  login = async (e) => {
    e.preventDefault();
    const { username, password } = this.state;
    console.log("username", username);
    console.log("password", password);
    if (username !== "" && password !== "") {
      const data = {
        username,
        password,
      };
      await axios
        .post("/user/login", {
          username: this.state.username,
          password: this.state.password,
        })
        .then((res) => {
          history.push('/statistical')
          window.location.reload()
        })
        .catch((err) => {
          console.log("err", err.response);
        });

    } else {
      alert("Hãy nhập đủ username và password");
    }
  };

  _updateField = (field) => (e) => this.setState({ [field]: e.target.value });
  render() {
    return (
      <div className="w-100">
        <div className="container min-vh-100">
          <div className="row vh-100 d-flex justify-content-center align-content-center">
            <div className="col-sm-9 col-md-7 col-lg-5 mx-auto">
              <div className="card border-0 shadow rounded-3 my-5">
                <div className="card-body p-4 p-sm-5">
                  <h5 className="card-title text-center mb-5 fw-bolder fs-1 fs-5 text-dark">
                    Sign In
                  </h5>
                  <form onSubmit={this.login}>
                    <div className="form-floating mb-3">
                      <input
                        type="text"
                        className="form-control"
                        id="floatingInput"
                        placeholder="User name"
                        name="username"
                        onChange={this._updateField("username")}
                      />
                      <label htmlFor="floatingInput" className="text-secondary">Email address</label>
                    </div>
                    <div className="form-floating mb-3">
                      <input
                        type="password"
                        className="form-control"
                        id="floatingPassword"
                        placeholder="Password"
                        name="password"
                        onChange={this._updateField("password")}
                      />
                      <label htmlFor="floatingPassword" className="text-secondary">Password</label>
                    </div>
                    <div className="d-grid">
                      <button
                        className="btn btn-primary btn-login text-uppercase fw-bold py-2"
                        type="submit"
                      >
                        Sign in
                      </button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
export default Login;
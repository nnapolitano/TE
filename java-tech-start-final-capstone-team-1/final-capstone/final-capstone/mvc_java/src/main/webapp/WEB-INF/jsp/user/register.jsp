<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/main/header.jsp"/>


<script type="text/javascript">
    $(document).ready(function () {
        $.validator.addMethod('capitals', function (thing) {
            return thing.match(/[A-Z]/);
        });


        $("form").validate({

            rules: {
                firstName: {
                    required: true
                },
                lastName: {
                    required: true
                },
                userName: {
                    required: true

                },
                password: {
                    required: true,
                    minlength: 15,
                    capitals: true
                },
                confirmPassword: {
                    required: true,
                    equalTo: "#password"
                },

            },
            messages: {
                password: {
                    minlength: "Password too short, make it at least 15 characters",
                    capitals: "Field must contain a capital letter",
                },
                confirmPassword: {
                    equalTo: "Passwords do not match"
                }
            },
            errorClass: "error"
        });
    });
</script>
<!-- Begin Page Content -->
<div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
                <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                <div class="col-lg-7">
                    <div class="p-5">
                        <div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                        </div>


                        <form class="user" method="POST" action="register">
                            <input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}"/>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <input type="text" class="form-control form-control-user"
                                           name="firstName" id="firstName" placeholder="First Name">
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control form-control-user"
                                           name="lastName" id="lastName" placeholder="Last Name">
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="email" class="form-control form-control-user"
                                       name="userName" id="userName" placeholder="Email Address">
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <input type="password" class="form-control form-control-user"
                                           name="password" id="password" placeholder="Password">
                                </div>
                                <div class="col-sm-6">
                                    <input type="password" class="form-control form-control-user"
                                           name="confirmPassword" id="confirmPassword" placeholder="Repeat Password">
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary btn-user btn-block">
                                Register Account
                            </button>
                        </form>

                        <div class="text-center">
                            <a class="small" href="forgot-password">Forgot Password?</a>
                        </div>
                        <div class="text-center">
                            <a class="small" href="login">Already have an account? Login!</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<!-- End of Page Content -->

<c:import url="/WEB-INF/jsp/main/footer.jsp"/>
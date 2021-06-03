import './styles.css';

function Register() {
  return (

    <div>
      <div class="Heading">
        <h1>Registration</h1>
      </div>
      <div class="com">
        <h3>
        <h2>Registration Fee Details:</h2>
        <table class="center">
        <tr>
        <th>Category</th>
        <th>Indian</th>
	      <th>Foreign (USD)</th>
        </tr>
        <tr>
        <td>Student</td>
        <td>5000</td>
       <td>100</td>
       </tr>
       <tr>
       <td>Academia</td>
       <td>6000</td>
	      <td>200</td>
        </tr>
        <tr>
        <td>Industry Delegates</td>
        <td>6000</td>
	      <td>200</td>
        </tr>
        </table>
<div class="main-block">
    <form align="center">
      <label for="fname">First name:</label>
      <input type="text" id="fname" name="fname" /><br /><br />
      <label for="lname">Last name:</label>
      <input type="text" id="lname" name="lname" /><br /><br />

      <label for="rad">Category:</label>
      <input type="radio" id="Student" name="cate" value="Student"/>
      <label for="Student">Student</label>
      <input type="radio" id="Academia" name="cate" value="Academia"/>
      <label for="Academia">Academia</label>
      <input type="radio" id="Industry Delegates" name="cate" value="Industry Delegates"/>
      <label for="Industry Delegates">Industry Delegates</label><br /><br />

    <label for="r">Gender:</label>
      <input type="radio" id="Male" name="gender" value="Male"/>
      <label for="Student">Male</label>
      <input type="radio" id="Female" name="gender" value="Female"/>
      <label for="Academia">Female</label>
      <input type="radio" id="Other" name="gender" value="Other"/>
      <label for="Industry Delegates">Other</label><br /><br />
      <input type="submit" value="Submit"/>
    </form>
</div>
        </h3>
      </div>
    </div>
  );
}

export default Register;

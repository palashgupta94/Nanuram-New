
<%@ page isELIgnored="false" %>
<%@taglib uri ="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!Doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="<c:url value="/resources/static/css/style.css"></c:url>">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <link href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>members Registration Form</title>
</head>
<body>

<div class="headingContainer">

    Person Information

</div>

<div class="formContainer mt-3" >

    <form:form action="save" method="post"  enctype="multipart/form-data" modelAttribute="family">

        <div class="table-responsive">

            <table class="table table-bordered " >

                <thead class="thead-dark">

                <tr>
                    <th>First Name</th>
                    <th>Middle Name</th>
                    <th>Last Name</th>
                    <th >Status</th>
                    <th >Relation With Head</th>
                    <th >Gender</th>
                    <th >DOB</th>
                    <th >Age</th>
                    <th >Family Gotra</th>
                    <th >Mother Gotra</th>
                    <th >Education</th>
                    <th >Occupation</th>
                    <th >Marital Status</th>
                    <th >Special Ability</th>
                    <th > Mobile Number</th>
                    <th>Image</th>

                </tr>

                </thead>
                <tbody id="tBody">

                <% int rowNum = (int)request.getAttribute("rowNum");
                    System.out.println("row Num :" + rowNum);

                    for(int i = 0; i < rowNum; i++){

                        pageContext.setAttribute("i" , i);

                %>

                <tr id ="${i}">
                    <td>
                      <div class="input-group input-group-md">
                            <form:input path="member[${i}].firstName"
                                        type="text"
                                        class="form-control"
                                        placeholder="First Name"
                                        name="firstName"
                                        value="${family.member.get(i).firstName}"
                            />

                            <div class="invalid-feedback">
                                    ${firstNameHasBindError}
                            </div>

                        </div>

                            <%--                ---------------------------------------------------------------------------------------------%>

                    <td>
                        <div class="input-group input-group-md">
                            <form:input path="member[${i}].middleName"
                                        type="text"
                                        class="form-control"
                                        placeholder="Middle Name"
                                        name="middleName"
                                        value="${family.member.get(i).middleName}"
                            />

                        </div>
                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->
                    <td>
                        <div class="input-group input-group-md">
                            <form:input path="member[${i}].lastName"
                                        type="text"
                                        class="form-control"
                                        placeholder="Last name"
                                        name="lastName"
                                        value="${family.member.get(i).lastName}"

                            />

                        </div>
                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->
                    <td>
                        <div class="input-group input-group-md">
                            <form:input path="member[${i}].status"
                                        type="text"
                                        class="form-control"
                                        placeholder="Status"
                                        name="status"
                                        value="${family.member.get(i).status}"
                            />

                        </div>
                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->
                    <td>
                        <div class="input-group input-group-md">
                            <form:input path="member[${i}].relationWithHead"
                                        type="text"
                                        class="form-control"
                                        placeholder="Relation with head"
                                        name="relationWithHead"
                                        value="${family.member.get(i).relationWithHead}"
                            />

                        </div>
                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->
                    <td>
                        <div class="input-group input-group-md">

                            <form:select path="member[${i}].gender" class = "form-select" name="gender" >

                                <form:option value="">Gender...</form:option>
                                <option selected ="${family.member.get(i).gender}"></option>
                                <form:option value="Male" />
                                <form:option value="Female"/>

                            </form:select>
                        </div>

                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->
                    <td>
                        <div class="input-group input-group-md" >
                            <form:input path="member[${i}].DOB"
                                        type="text"
                                        class="form-control dobSelect"
                                        placeholder="Date of Birth"
                                        name="DOB"
                                        value="${family.member.get(i).DOB}"
                            />

                        </div>
                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->
                    <td>
                        <div class="input-group input-group-md">

                            <form:select path="member[${i}].age" class = "form-select" name="age" >

<%--                                <form:option disabled="true" d value="${-1}">Age...</form:option>--%>
                                <option selected="${family.member.get(i).age}"></option>
                                <form:options items="${rd.get('ageMap')}" />

                            </form:select>
                        </div>
                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->
                    <td>
                        <div class="input-group input-group-md">
                            <form:input path="member[${i}].familyGotra"
                                        type="text"
                                        class="form-control"
                                        placeholder="Family Gotra"
                                        name="familyGotra"
                                        value="${family.member.get(i).familyGotra}"
                            />

                        </div>
                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->
                    <td>
                        <div class="input-group input-group-md">
                            <form:input path="member[${i}].motherGotra"
                                        type="text"
                                        class="form-control"
                                        placeholder="Mother Gotra"
                                        name="motherGotra"
                                        value="${family.member.get(i).motherGotra}"
                            />

                        </div>

                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->
                    <td>
                        <div class="input-group input-group-md">
                            <form:input path="member[${i}].educationalStatus"
                                        type="text"
                                        class="form-control"
                                        placeholder="Education"
                                        name="educationalStatus"
                                        value="${family.member.get(i).educationalStatus}"

                            />

                        </div>
                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->
                    <td>
                        <div class="input-group input-group-md">
                            <form:input path="member[${i}].occupation"
                                        type="text"
                                        class="form-control"
                                        placeholder="Occupation"
                                        name="occupation"
                                        value="${family.member.get(i).occupation}"
                            />

                        </div>
                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->
                    <td>
                        <div class="input-group input-group-md">

                            <form:select path="member[${i}].maritalStatus" class = "form-select" >

                                <option selected=${family.member.get(i).maritalStatus}></option>
                                <form:option value="Married" />
                                <form:option value="Unmarried" />

                            </form:select>
                        </div>

                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->
                    <td>
                        <div class="input-group input-group-md">


                            <form:select path="member[${i}].specialAbility" class = "form-select" >

                                <option selected="${family.member.get(i).speciallyAble}">
                                <form:option value="false">No</form:option>
                                <form:option value="true">Yes</form:option>

                            </form:select>
                        </div>

                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->
                    <!-- ----------------------------------------------------------------------------------- -->

                    <td>

                        <!-- Button trigger modal -->
                        <button type="button" class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#NumberModal-${i}">
                            Mobile Number
                        </button>

                        <!-- Modal -->
                        <div class="modal fade" id="NumberModal-${i}" tabindex="-1" aria-labelledby="mobileModalLabel" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="mobileModalLabel">Mobile Number</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">

                                        <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                                <form:select path="member[${i}].mobileNumbers[0].type"
                                                             class="form-select"
                                                             name="members[${i}].mobileNumbers[0].type" >

<%--                                                    <form:option value="NONE" label="---Type---" />--%>
                                                    <option selected="${family.member.get(i).mobileNumbers.get(0).type}"></option>
                                                    <form:options items="${rd.get('typeMap')}" />

                                                </form:select>
                                            </div>

                                            <form:input path="member[${i}].mobileNumbers[0].mobileNumber"
                                                        type="text"
                                                        class="form-control"
                                                        placeholder="Mobile Number"
                                                        name="members[${i}].mobileNumbers[0].mobileNumber"
                                                        value="${family.member.get(i).mobileNumbers.get(0).mobileNumber}"
                                            />


                                            <div class="input-group-append">
                                                <form:select path="member[${i}].mobileNumbers[0].primaryString"
                                                             class="form-select"
                                                             name="members[${i}].mobileNumbers[0].primaryString">

<%--                                                    <form:option value="${null}" label="Primary"/>--%>
                                                    <option selected="${family.member.get(i).mobileNumbers.get(0).primary}" ></option>
                                                    <form:options items="${rd.get('primaryMap')}" />


                                                </form:select>

                                            </div>
                                        </div>

                                            <%--                --------------------------------------------------------------------------------                        --%>

                                        <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                                <form:select path="member[${i}].mobileNumbers[1].type"
                                                             class="form-select"
                                                             name="members[${i}].mobileNumbers[1].type"
                                                >

<%--                                                    <form:option value="NONE" label="---Type---" select="${personWrapper.members[i].mobileNumbers[1].type}"/>--%>
                                                    <option selected="${family.member.get(i).mobileNumbers.get(1).type}" ></option>
                                                    <form:options items="${rd.get('typeMap')}" />

                                                </form:select>
                                            </div>
                                            <form:input path="member[${i}].mobileNumbers[1].mobileNumber"
                                                        type="text"
                                                        class="form-control"
                                                        placeholder="Mobile Number"
                                                        value="${family.member.get(i).mobileNumbers.get(1).mobileNumber}"
                                            />
                                            <div class="input-group-append">
                                                <form:select path="member[${i}].mobileNumbers[1].primaryString" class="form-select">

<%--                                                    <form:option value="" label="Primary" select="${personWrapper.members[i].mobileNumbers[1].primaryString}" />--%>
                                                    <option selected="${family.member.get(i).mobileNumbers.get(1).primary}" ></option>
                                                    <form:options items="${rd.get('primaryMap')}" />
                                                </form:select>

                                            </div>
                                        </div>
                                            <%--                 ------------------------------------------------------------------------------------------                       --%>

                                        <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                                <form:select path="member[${i}].mobileNumbers[2].type" class="form-select" id="3-type" >
<%--                                                    <form:option value="NONE" label="---Type---" />--%>
                                                    <option selected="${family.member.get(i).mobileNumbers.get(2).type}" ></option>
                                                    <form:options items="${rd.get('typeMap')}" />
                                                </form:select>
                                            </div>
                                            <form:input path="member[${i}].mobileNumbers[2].mobileNumber"
                                                        type="text"
                                                        class="form-control"
                                                        placeholder="Mobile Number"
                                                        value="${family.member.get(i).mobileNumbers.get(2).mobileNumber}"
                                            />

                                            <div class="input-group-append">
                                                <form:select path="member[${i}].mobileNumbers[2].primaryString" class="form-select">

<%--                                                    <form:option value="" >Primary</form:option>--%>
                                                    <option selected="${family.member.get(i).mobileNumbers.get(2).primary}"></option>
                                                    <form:options items="${rd.get('primaryMap')}" />
                                                </form:select>

                                            </div>
                                        </div>

                                            <%---------------------------------------------------------------------------------------------                        --%>
                                        <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                                <form:select path="member[${i}].mobileNumbers[3].type" class="form-select" id="3-type" >
<%--                                                    <form:option value="NONE" label="---Type---" />--%>
                                                    <option selected="${family.member.get(i).mobileNumbers.get(3).type}"></option>
                                                    <form:options items="${rd.get('typeMap')}" />
                                                </form:select>
                                            </div>
                                            <form:input path="member[${i}].mobileNumbers[3].mobileNumber" type="text" class="form-control" placeholder="Mobile Number"
                                            value="${family.member.get(i).mobileNumbers.get(3).mobileNumber}"
                                            />
                                            <div class="input-group-append">
                                                <form:select path="member[${i}].mobileNumbers[3].primaryString" class="form-select">
<%--                                                    <form:option value="">Primary</form:option>--%>
                                                    <option selected="${family.member.get(i).mobileNumbers.get(3).primary}"></option>
                                                    <form:options items="${rd.get('primaryMap')}" />
                                                </form:select>

                                            </div>
                                        </div>

                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    </div>
                                </div>
                            </div>
                        </div>


                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->


                    <td>
                        <div class="mb-3">
                            <form:input path="member[${i}].imageFile"  class="form-control form-control-sm" id="formFileSm" type="file" name="imgFile" />
                                <%--                        <input type="file" class="form-control form-control-sm" id="formFileSm"/>--%>
                        </div>
                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->

                    <!-- ----------------------------------------------------------------------------------------------------------- -->

                </tr>

                <% } %>

                </tbody>

            </table>

        </div>


        <div class="d-grid gap-2 mt-4">

            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#AddressModal">
                Address
            </button>
            <!-- Modal -->
            <div class="modal fade" id="AddressModal" tabindex="-1" aria-labelledby="AddressModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-xl">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="AddressModalLabel">Add Addresses</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div class="container">
                                <div class="row pt-2 pb-2">
                                    <div class="col-md-6">
                                        <div class="kapil">
                                            <div class="palash">
                                                Address 1
                                            </div>
                                            <div class="row g-3">
                                                <div class="col-md-6">
                                                    <label for="inputName" class="form-label"> First Name</label>
                                                    <form:input path="addresses[0].firstName" type="text" class="form-control" id="inputName" placeholder="First Name"
                                                    value="${family.addresses.get(0).firstName}"
                                                    />
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="inputLastName" class="form-label">Last Name</label>
                                                    <form:input path="addresses[0].lastName" type="text" class="form-control" id="inputLastName" placeholder="Last Name"
                                                                value="${family.addresses.get(0).lastName}"
                                                    />
                                                </div>
                                                <div class="col-12">
                                                    <label for="inputAddress" class="form-label">Address 1</label>
                                                    <form:input path="addresses[0].address1" type="text" class="form-control" id="inputAddress" placeholder="1234 Main St"
                                                                value="${family.addresses.get(0).address1}"
                                                    />
                                                </div>
                                                <div class="col-12">
                                                    <label for="inputAddress2" class="form-label">Address 2</label>
                                                    <form:input path="addresses[0].address2" type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor"

                                                                value="${family.addresses.get(0).address2}"
                                                    />
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="inputCity" class="form-label">City</label>
                                                    <form:input path="addresses[0].city" type="text" class="form-control" id="inputCity" placeholder = "City"
                                                                value="${family.addresses.get(0).city}"
                                                    />
                                                </div>

                                                <div class="col-md-6">
                                                    <label for="inputDistrict" class="form-label">District</label>
                                                    <form:select path="addresses[0].district" id="inputDistrict" class="form-select">
<%--                                                        <form:option value="null" >Choose...</form:option>--%>
                                                        <option selected="${family.addresses.get(0).district}"></option>
                                                        <form:options items="${rd.get('districtMap')}" />
                                                    </form:select>
                                                </div>

                                                <div class="col-md-6">
                                                    <label for="inputState" class="form-label">State</label>
                                                    <form:select path="addresses[0].state" id="inputState" class="form-select">
                                                        <option selected="${family.addresses.get(0).state}"></option>
                                                        <form:options items="${rd.get('stateMap')}" />
                                                    </form:select>
                                                </div>

                                                <div class="col-md-6">
                                                    <label for="inputZip" class="form-label">Zip</label>
                                                    <form:input path="addresses[0].pinCode" type="text" class="form-control" id="inputZip" placeholder="Zin/Pin Code"
                                                                value="${family.addresses.get(0).pinCode}"
                                                    />
                                                </div>

                                                <div class="col-md-6">
                                                    <label for="inputCountry" class="form-label">Country</label>
                                                    <form:input path="addresses[0].country" type="text" class="form-control" id="inputCountry"
                                                                value="${family.addresses.get(0).country}"
                                                    />
                                                </div>

                                                <div class="col-md-6">
                                                    <label class="form-label">Type</label>
                                                    <form:select path="addresses[0].addressType" class ="form-select">
<%--                                                        <form:option value="">Choose...</form:option>--%>
                                                        <option selected="${family.addresses.get(0).addressType}"
                                                        <form:options items="${rd.get('addressTypeMap')}" />
                                                    </form:select>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="kapil">
                                            <div class="palash">
                                                Address 2
                                            </div>
                                            <div class="row g-3">
                                                <div class="col-md-6">
                                                    <label for="inputName" class="form-label"> First Name</label>
                                                    <form:input path="addresses[1].firstName" type="text" class="form-control" id="inputName" placeholder="First Name"
                                                                value="${family.addresses.get(1).firstName}"
                                                    />
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="inputLastName" class="form-label">Last Name</label>
                                                    <form:input path="addresses[1].lastName" type="text" class="form-control" id="inputLastName" placeholder="Last Name"

                                                                value="${family.addresses.get(1).lastName}"
                                                    />
                                                </div>
                                                <div class="col-12">
                                                    <label for="inputAddress" class="form-label">Address 1</label>
                                                    <form:input path="addresses[1].address1" type="text" class="form-control" id="inputAddress" placeholder="1234 Main St"

                                                                value="${family.addresses.get(1).address1}"
                                                    />
                                                </div>
                                                <div class="col-12">
                                                    <label for="inputAddress2" class="form-label">Address 2</label>
                                                    <form:input path="addresses[1].address2" type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor"

                                                                value="${family.addresses.get(1).address2}"
                                                    />
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="inputCity" class="form-label">City</label>
                                                    <form:input path="addresses[1].city" type="text" class="form-control" id="inputCity" placeholder = "City"

                                                                value="${family.addresses.get(1).city}"

                                                    />
                                                </div>

                                                <div class="col-md-6">
                                                    <label for="inputDistrict" class="form-label">District</label>
                                                    <form:select path="addresses[1].district" id="inputDistrict" class="form-select">
                                                        <option selected="${family.addresses.get(1).district}"></option>
                                                        <form:options items="${rd.get('districtMap')}" />
                                                    </form:select>
                                                </div>

                                                <div class="col-md-6">
                                                    <label for="inputState" class="form-label">State</label>
                                                    <form:select path="addresses[1].state" id="inputState" class="form-select">
                                                        <option selected="${family.addresses.get(1).state}"></option>
                                                        <form:options items="${rd.get('stateMap')}" />
                                                    </form:select>
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="inputZip" class="form-label">Zip</label>
                                                    <form:input path="addresses[1].pinCode" type="text" class="form-control" id="inputZip" placeholder="Zip/Pin Code"

                                                                value="${family.addresses.get(1).pinCode}"
                                                    />
                                                </div>

                                                <div class="col-md-6">
                                                    <label for="inputCountry" class="form-label">Country</label>
                                                    <form:input path="addresses[1].country" type="text" class="form-control" id="inputCountry" value="${family.addresses.get(1).country}" />
                                                </div>

                                                <div class="col-md-6">
                                                    <label class="form-label">Type</label>
                                                    <form:select path="addresses[1].addressType" class = "form-select">
<%--                                                        <form:option value="">Choose...</form:option>--%>
                                                        <option selected="${family.addresses.get(1).addressType}"
                                                        <form:options items="${rd.get('addressTypeMap')}"  />
                                                    </form:select>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row pt-4 pb-4">
                                    <div class="col-md-6">
                                        <div class="kapil">
                                            <div class="palash">
                                                Address 3
                                            </div>
                                            <div class="row g-3">
                                                <div class="col-md-6">
                                                    <label for="inputName" class="form-label"> First Name</label>
                                                    <form:input path="addresses[2].firstName" type="text" class="form-control" id="inputName" placeholder="First Name"
                                                    value="${family.addresses.get(2).firstName}"
                                                    />
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="inputLastName" class="form-label">Last Name</label>
                                                    <form:input path="addresses[2].lastName" type="text" class="form-control" id="inputLastName" placeholder="Last Name" value="${family.addresses.get(2).lastName}" />
                                                </div>
                                                <div class="col-12">
                                                    <label for="inputAddress" class="form-label">Address 1</label>
                                                    <form:input path="addresses[2].address1" type="text" class="form-control" id="inputAddress" placeholder="1234 Main St" value="${family.addresses.get(2).address1}" />
                                                </div>
                                                <div class="col-12">
                                                    <label for="inputAddress2" class="form-label">Address 2</label>
                                                    <form:input path="addresses[2].address2" type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor" value="${family.addresses.get(2).address2}" />
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="inputCity" class="form-label">City</label>
                                                    <form:input path="addresses[2].city" type="text" class="form-control" id="inputCity" placeholder = "City"  value="${family.addresses.get(2).city}"/>
                                                </div>

                                                <div class="col-md-6">
                                                    <label for="inputDistrict" class="form-label">District</label>
                                                    <form:select path="addresses[2].district" id="inputDistrict" class="form-select">
                                                        <option selected="${family.addresses.get(2).district}"></option>
                                                        <form:options items="${rd.get('districtMap')}" />
                                                    </form:select>
                                                </div>

                                                <div class="col-md-6">
                                                    <label for="inputState" class="form-label">State</label>
                                                    <form:select path="addresses[2].state" id="inputState" class="form-select">
                                                        <option selected="${family.addresses.get(2).state}"></option>
                                                        <form:options items="${rd.get('stateMap')}" />
                                                    </form:select>
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="inputZip" class="form-label">Zip</label>
                                                    <form:input path="addresses[2].pinCode" type="text" class="form-control" id="inputZip" placeholder="Zin/Pin Code" value="${family.addresses.get(2).pinCode}"/>
                                                </div>

                                                <div class="col-md-6">
                                                    <label for="inputCountry" class="form-label">Country</label>
                                                    <form:input path="addresses[2].country" type="text" class="form-control" id="inputCountry" value="${family.addresses.get(2).country}"/>
                                                </div>

                                                <div class="col-md-6">
                                                    <label class="form-label">Type</label>
                                                    <form:select path="addresses[2].addressType" Class="form-select">
<%--                                                        <form:option value="">Choose...</form:option>--%>
                                                        <option selected="${family.addresses.get(2).addressType}"
                                                        <form:options items="${rd.get('addressTypeMap')}" />
                                                    </form:select>
                                                </div>

                                            </div>
                                        </div>
                                    </div>


                                    <div class="col-md-6">
                                        <div class="kapil">
                                            <div class="palash">
                                                Address 4
                                            </div>
                                            <div class="row g-3">
                                                <div class="col-md-6">
                                                    <label for="inputName" class="form-label"> First Name</label>
                                                    <form:input path="addresses[3].firstName" type="text" class="form-control" id="inputName" placeholder="First Name"
                                                        value="${family.addresses.get(3).firstName}"
                                                    />
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="inputLastName" class="form-label">Last Name</label>
                                                    <form:input path="addresses[3].lastName" type="text" class="form-control" id="inputLastName" placeholder="Last Name"

                                                        value="${family.addresses.get(3).lastName}"
                                                    />
                                                </div>
                                                <div class="col-12">
                                                    <label for="inputAddress" class="form-label">Address 1</label>
                                                    <form:input path="addresses[3].address1" type="text" class="form-control" id="inputAddress" placeholder="1234 Main St"
                                                        value="${family.addresses.get(3).address1}"
                                                    />
                                                </div>
                                                <div class="col-12">
                                                    <label for="inputAddress2" class="form-label">Address 2</label>
                                                    <form:input path="addresses[3].address2" type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor"
                                                        value="${family.addresses.get(3).address2}"

                                                    />
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="inputCity" class="form-label">City</label>
                                                    <form:input path="addresses[3].city" type="text" class="form-control" id="inputCity" placeholder = "City"
                                                        value="${family.addresses.get(3).city}"

                                                    />
                                                </div>

                                                <div class="col-md-6">
                                                    <label for="inputDistrict" class="form-label">District</label>
                                                    <form:select path="addresses[3].district" id="inputDistrict" class="form-select">
                                                        <option selected="${family.addresses.get(3).district}"></option>
                                                        <form:options items="${rd.get('districtMap')}" />
                                                    </form:select>
                                                </div>

                                                <div class="col-md-6">
                                                    <label for="inputState" class="form-label">State</label>
                                                    <form:select path="addresses[3].state" id="inputState" class="form-select">
                                                        <option selected="${family.addresses.get(3).state}" ></option>
                                                        <form:options items="${rd.get('stateMap')}" />
                                                    </form:select>
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="inputZip" class="form-label">Zip</label>
                                                    <form:input path="addresses[3].pinCode" type="text" class="form-control" id="inputZip" placeholder="Zin/Pin Code" value="${family.addresses.get(3).pinCode}"/>
                                                </div>

                                                <div class="col-md-6">
                                                    <label for="inputCountry" class="form-label">Country</label>
                                                    <form:input path="addresses[3].country" type="text" class="form-control" id="inputCountry" value="${family.addresses.get(3).country}"/>
                                                </div>

                                                <div class="col-md-6">
                                                    <label class="form-label">Type</label>
                                                    <form:select path="addresses[3].addressType" class="form-select">
<%--                                                        <form:option value="">Choose...</form:option>--%>
                                                        <option selected="${family.addresses.get(3).addressType}"></option>
                                                        <form:options items="${rd.get('addressTypeMap')}"/>

                                                    </form:select>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-lg btn-outline-secondary"  data-bs-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>



            <input type="submit" value="Submit Form" class="btn btn-outline-success mt-1">

        </div>



    </form:form>


</div>










<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js" integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU=" crossorigin="anonymous"></script>

<script src="<c:url value="/resources/static/js/row.js" />"></script>
<script src="<c:url value="/resources/static/js/dobSelect.js" />"></script>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>


</body>
</html>
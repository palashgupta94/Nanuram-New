$(document).ready(function(){
    console.log("document is ready")

    let rowIdx = 0;

    $('#addBtn').on('click' , function(){
        console.log("button clicked")
        // console.log(++0
        // );

        $('#tBody').append(`

            <tr id="R${++rowIdx}" >
                    <td>
                        <div class="input-group input-group-md">
                            <input name="firstName" path="members[rowIdx].firstName"  class="form-control" placeholder="First Name" />
                        </div>
                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->
                    <td>
                        <div class="input-group input-group-md">
                            <input name="lastName" path="members[rowIdx].lastName" class="form-control" placeholder="Last name" />
                        </div>
                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->
                    <td>
                        <div class="input-group input-group-md">
                            <input path="members[rowIdx].status" class="form-control" placeholder="Status" /></div>
                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->
                    <td>
                        <div class="input-group input-group-md">
                            <input path="members[rowIdx].relationWithHead" class="form-control" placeholder="Relation with head" /></div>
                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->
                    <td>
                        <div class="input-group input-group-md">
                            <input path="members[rowIdx].gender" class="form-control" placeholder="Gender" /></div>
                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->
                    <td>
                        <div class="input-group input-group-md">
                            <input path="members[rowIdx].DOB" class="form-control" placeholder="Date of Birth" /></div>
                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->
                    <td>
                        <div class="input-group input-group-md">
                            <input path="members[rowIdx].age" class="form-control" placeholder="Age" /></div>
                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->
                    <td>
                        <div class="input-group input-group-md">
                            <input path="members[rowIdx].familyGotra" class="form-control"  placeholder="Family Gotra" /></div>
                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->
                    <td>
                        <div class="input-group input-group-md">
                            <input path="members[rowIdx].motherGotra" class="form-control"  placeholder="Mother Gotra" /></div>
                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->
                    <td>
                        <div class="input-group input-group-md">
                            <input path="members[rowIdx].educationalStatus" class="form-control" placeholder="Education" /></div>
                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->
                    <td>
                        <div class="input-group input-group-md">
                            <input path="members[rowIdx].occupation" class="form-control" placeholder="Occupation" /></div>
                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->
                    <td>
                        <div class="input-group input-group-md">
                            <input path="members[rowIdx].married" class="form-control" placeholder="Marital Status" /></div>
                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->
                    <td>
                        <div class="input-group input-group-md">
                            <input path="members[rowIdx].speciallyAble" class="form-control" placeholder="Special Ability" /></div>
                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->
                    <td>
                        <div class="input-group input-group-md">
                            <input path="members[rowIdx].contactNumber" class="form-control" placeholder="Mobile Number" /></div>
                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->
                    <td>
                        <div class="mb-3">
                            <input path="members[rowIdx].imgUrl"  class="form-control form-control-sm" id="formFileSm" type="file" />
                        </div>
                    </td>
                    <!-- ----------------------------------------------------------------------------------- -->
                    <td>
                        <div class="text-center">
                        
                            <button type="button" class="btn btn-danger" id="rmvBtn">Add Row</button>
                            <!-- <input type="reset" value="Reset Form" class="btn btn-warning reset"> -->
                        </div>
                    </td>
                <!-- ----------------------------------------------------------------------------------------------------------- -->
                
                    </tr>`
        );

    });

    $('#tBody').on('click' , '#rmvBtn' , function(){

        var child = $(this).closest('tr').nextAll();
        child.each(function(){

            var id = $(this).attr('id');
            var dig = parseInt(id.substring(1));
            $(this).attr('id' , `R${dig-1}`);
        });

        $(this).closest('tr').remove();

        rowIdx--;

    });





});



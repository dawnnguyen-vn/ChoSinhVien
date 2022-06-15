<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>

<section class="m-5">
    <div class="container white p-5">
        <form:form action="/dang-tin" method="post" modelAttribute="product" enctype="multipart/form-data">
            <div class="row">

                <div class="col-md-4">
                    <form:input class="mb-3" type="file" id="files" name="image_file_arr[]" multiple="multiple"
                                path="image"/>
                    <br>
                    <output id="list-select-img"></output>
                </div>
                <div class="col-md-8">
                    <form:select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" path="category">
                        <option disabled selected>Loại sản phẩm</option>
                        <form:options items="${categories}" itemLabel="name" itemValue="slug" ></form:options>
                    </form:select>

                    <h4 class="mt-4">Giá</h4>
                    <form:input type="number" class="form-control" required="true" autofocus="true" path="price"/>
                    <h4 class="mt-4">Tiêu đề</h4>
                    <form:input class="form-control form-control-lg" type="text"
                                aria-label=".form-control-lg example" path="name"/>
                    <h4 class="mt-4">Mô tả chi tiết</h4>
                    <div>
                        <form:textarea class="form-control" id="exampleFormControlTextarea1" rows="3"
                                       path="description"></form:textarea>
                    </div>
                    <form:select onmousedown="(function(e){ e.preventDefault(); })(event, this)" id="selectLocation"
                            class="form-select form-select-lg mt-4 mb-3" aria-label=".form-select-lg example" path="location">
                        <option id="opt-location" selected>Địa chỉ</option>
                    </form:select>
                    <div class="row mt-5">
                        <div class="col-6">
                            <button type="button" class="btn btn-outline-primary width-100">XEM TRƯỚC</button>
                        </div>
                        <div class="col-6">
                            <button type="submit" class="btn btn-primary width-100">ĐĂNG TIN</button>
                        </div>
                    </div>
                </div>


            </div>
        </form:form>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" style="text-align: center;" id="exampleModalLabel">Địa chỉ</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <select id="sl-province" style="margin-bottom: 1rem;" class="form-select"
                            aria-label="Default select example">
                        <option disabled selected>Tỉnh, thành phố</option>
                    </select>

                    <select id="sl-district" style="margin-bottom: 1rem;" class="form-select"
                            aria-label="Default select example">
                        <option disabled selected>Quận, huyện, thị Xã</option>
                    </select>

                    <select id="sl-ward" style="margin-bottom: 1rem" class="form-select"
                            aria-label="Default select example">
                        <option disabled selected>Phường, xã, thị trấn</option>
                    </select>
                    <input id="input-specification" type="text" placeholder="Địa chỉ cụ thể" class="form-control"
                           aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                </div>
                <div class="modal-footer">
                    <button onclick="handleDone()" type="button" class="btn btn-primary">Xong</button>
                </div>
            </div>
        </div>
    </div>


</section>

<script>
    const selectLocation = document.getElementById("selectLocation");
    selectLocation.addEventListener("click", () => {
        $('#exampleModal').modal('show');
    })
    const selectProvince = document.getElementById("sl-province");
    const selectDistrict = document.getElementById("sl-district");
    const selectWard = document.getElementById("sl-ward");
    const optLocation = document.getElementById("opt-location");
    const inputSpecification = document.getElementById("input-specification");
    fetch('http://localhost:8080/api/location/province')
        .then(response => response.json())
        .then(data => {
            for (let d of data) {
                let opt = document.createElement('option');
                opt.value = d.id;
                opt.innerHTML = d.name;
                selectProvince.appendChild(opt);
            }
        });

    selectProvince.onchange = () => {
        fetch('http://localhost:8080/api/location/province/' + selectProvince.value + "/district")
            .then(response => response.json())
            .then(data => {
                selectDistrict.replaceChildren();
                let opt0 = document.createElement('option');
                opt0.innerHTML = "Quận, huyện, thị Xã";
                opt0.disabled = true;
                opt0.selected = true;
                selectDistrict.appendChild(opt0);
                for (let d of data) {
                    let opt = document.createElement('option');
                    opt.value = d.id;
                    opt.innerHTML = d.name;
                    selectDistrict.appendChild(opt);
                }
            });
    }

    selectDistrict.onchange = () => {
        fetch('http://localhost:8080/api/location/province/' + selectProvince.value + "/district/" + selectDistrict.value + "/ward")
            .then(response => response.json())
            .then(data => {
                selectWard.replaceChildren();
                let opt0 = document.createElement('option');
                opt0.innerHTML = "Phường, xã, thị trấn";
                opt0.disabled = true;
                opt0.selected = true;
                selectWard.appendChild(opt0);
                for (let d of data) {
                    let opt = document.createElement('option');
                    opt.value = d.id;
                    opt.innerHTML = d.name;
                    selectWard.appendChild(opt);
                }
            });
    }

    const handleDone = () => {
        let ward = selectWard.options[selectWard.selectedIndex].text;
        let district = selectDistrict.options[selectDistrict.selectedIndex].text;
        let province = selectProvince.options[selectProvince.selectedIndex].text;
        optLocation.value = inputSpecification.value +
            ',' + selectWard.value + ',' + selectDistrict.value + ',' + selectProvince.value;

        optLocation.innerText = inputSpecification.value +
            ', ' + ward + ', ' + district + ', ' + province;
        $('#exampleModal').modal('hide');
    }

</script>


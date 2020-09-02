<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="app-page-title">
	<div class="page-title-wrapper">
		<div class="page-title-heading">
			<div class="page-title-icon">
				<i class="pe-7s-glasses icon-gradient bg-love-kiss"> </i>
			</div>
			<div>
				Register Hotel
				<div class="page-title-subheading">Notifications represent one
					of the best ways to give feedback for various users actions.</div>
			</div>
		</div>
		<div class="page-title-actions">
			<button type="button" data-toggle="tooltip" title="Example Tooltip"
				data-placement="bottom" class="btn-shadow mr-3 btn btn-dark">
				<i class="fa fa-star"></i>
			</button>
			<div class="d-inline-block dropdown">
				<button type="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"
					class="btn-shadow dropdown-toggle btn btn-info">
					<span class="btn-icon-wrapper pr-2 opacity-7"> <i
						class="fa fa-business-time fa-w-20"></i>
					</span> Buttons
				</button>
				<div tabindex="-1" role="menu" aria-hidden="true"
					class="dropdown-menu dropdown-menu-right">
					<ul class="nav flex-column">
						<li class="nav-item"><a href="javascript:void(0);"
							class="nav-link"> <i class="nav-link-icon lnr-inbox"></i> <span>
									Inbox </span>
								<div class="ml-auto badge badge-pill badge-secondary">86</div>
						</a></li>
						<li class="nav-item"><a href="javascript:void(0);"
							class="nav-link"> <i class="nav-link-icon lnr-book"></i> <span>
									Book </span>
								<div class="ml-auto badge badge-pill badge-danger">5</div>
						</a></li>
						<li class="nav-item"><a href="javascript:void(0);"
							class="nav-link"> <i class="nav-link-icon lnr-picture"></i> <span>
									Picture </span>
						</a></li>
						<li class="nav-item"><a disabled href="javascript:void(0);"
							class="nav-link disabled"> <i
								class="nav-link-icon lnr-file-empty"></i> <span> File
									Disabled </span>
						</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<ul
	class="body-tabs body-tabs-layout tabs-animated body-tabs-animated nav">
	<li class="nav-item"><a role="tab" class="nav-link active"
		id="tab-0" data-toggle="tab" href="#tab-content-0"> <span>Register Form
				</span>
	</a></li>
	<li class="nav-item"><a role="tab" class="nav-link" id="tab-2"
		data-toggle="tab" href="#tab-content-2"> <span>Basic Alerts</span>
	</a></li>
</ul>
<div class="tab-content">
	<div class="tab-pane tabs-animation fade show active"
		id="tab-content-0" role="tabpanel">
		<div class="main-card mb-3 card">
			<div class="card-body">
				<div class="card-title">Enter Hotel Information</div>
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<label class="form-label" for="title"><h5>Hotel ID</h5></label> <input
								id="title" type="text" class="form-control"
								placeholder="ex) ht1001" />
						</div>
						<div class="form-group">
							<label class="form-label" for="message"><h5>NAME</h5></label> <input
								id="title" type="text" class="form-control"
								placeholder="ex) JW Mariott" />
						</div>
						<div class="form-group">
							<div class="form-check">
								<input id="closeButton" type="checkbox" value="checked"
									class="form-check-input" /> <label class="form-check-label"
									for="closeButton"> Close Button </label>
							</div>
							<div class="form-check">
								<input id="addBehaviorOnToastClick" type="checkbox"
									value="checked" class="form-check-input" /> <label
									class="form-check-label" for="addBehaviorOnToastClick">
									Add behavior on toast click </label>
							</div>
							<div class="form-check">
								<input disabled id="addBehaviorOnToastCloseClick"
									type="checkbox" value="checked" class="form-check-input" /> <label
									class="form-check-label" for="addBehaviorOnToastCloseClick">
									Add behavior on toast close button click </label>
							</div>
							<div class="form-check">
								<input id="debugInfo" type="checkbox" value="checked"
									class="form-check-input" /> <label class="form-check-label"
									for="debugInfo"> Debug </label>
							</div>
							<div class="form-check">
								<input id="progressBar" type="checkbox" value="checked"
									class="form-check-input" /> <label class="form-check-label"
									for="progressBar"> Progress Bar </label>
							</div>
							<div class="form-check">
								<input id="rtl" type="checkbox" value="checked"
									class="form-check-input" /> <label class="form-check-label"
									for="rtl"> Right-To-Left </label>
							</div>
							<div class="form-check">
								<input id="preventDuplicates" type="checkbox" value="checked"
									class="form-check-input" /> <label class="form-check-label"
									for="preventDuplicates"> Prevent Duplicates </label>
							</div>
							<div class="form-check">
								<input id="addClear" type="checkbox" value="checked"
									class="form-check-input" /> <label class="form-check-label"
									for="addClear"> Add button to force clearing a toast </label>
							</div>
							<div class="form-check">
								<input id="newestOnTop" type="checkbox" value="checked"
									class="form-check-input" /> <label class="form-check-label"
									for="newestOnTop"> Newest on top </label>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div id="toastTypeGroup">
							<h5>Grade</h5>
							<div class="form-check">
								<input type="radio" name="toasts" class="form-check-input"
									value="success" checked /> <label class="form-check-label"
									for="exampleRadios1"> 5-star </label>
							</div>
							<div class="form-check">
								<input type="radio" name="toasts" class="form-check-input"
									value="info" /> <label class="form-check-label"
									for="exampleRadios1"> 4-star </label>
							</div>
							<div class="form-check">
								<input type="radio" name="toasts" class="form-check-input"
									value="warning" /> <label class="form-check-label"
									for="exampleRadios1"> 3-star </label>
							</div>
							<div class="form-check">
								<input type="radio" name="toasts" class="form-check-input"
									value="error" /> <label class="form-check-label"
									for="exampleRadios1"> 2-star </label>
							</div>
							<div class="form-check">
								<input type="radio" name="toasts" class="form-check-input"
									value="error" /> <label class="form-check-label"
									for="exampleRadios1"> 1-star </label>
							</div>							
						</div>
						<div id="positionGroup">
							<h5>Amenities</h5>
							<div class="form-check">
								<input type="checkbox" name="positions" class="form-check-input"
									value="toast-top-right" checked /> <label
									class="form-check-label" for="exampleRadios1"> Top
									Right </label>
							</div>
							<div class="form-check">
								<input type="checkbox" name="positions" class="form-check-input"
									value="toast-bottom-right" /> <label class="form-check-label"
									for="exampleRadios1"> Bottom Right </label>
							</div>
							<div class="form-check">
								<input type="checkbox" name="positions" class="form-check-input"
									value="toast-bottom-left" /> <label class="form-check-label"
									for="exampleRadios1"> Bottom Left </label>
							</div>
							<div class="form-check">
								<input type="checkbox" name="positions" class="form-check-input"
									value="toast-top-left" /> <label class="form-check-label"
									for="exampleRadios1"> Top Left </label>
							</div>
							<div class="form-check">
								<input type="checkbox" name="positions" class="form-check-input"
									value="toast-top-full-width" /> <label class="form-check-label"
									for="exampleRadios1"> Top Full Width </label>
							</div>
							<div class="form-check">
								<input type="checkbox" name="positions" class="form-check-input"
									value="toast-bottom-full-width" /> <label
									class="form-check-label" for="exampleRadios1"> Bottom
									Full Width </label>
							</div>
							<div class="form-check">
								<input type="checkbox" name="positions" class="form-check-input"
									value="toast-top-center" /> <label class="form-check-label"
									for="exampleRadios1"> Top Center </label>
							</div>
							<div class="form-check">
								<input type="checkbox" name="positions" class="form-check-input"
									value="toast-bottom-center" /> <label class="form-check-label"
									for="exampleRadios1"> Bottom Center </label>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<h5>Address</h5>
						<div class="form-group">
							<label for="showEasing">City</label> <input
								id="showEasing" type="text" placeholder="swing, linear"
								class="form-control" value="서울특별시" />
						</div>
						<div class="form-group">
							<label for="hideEasing">Gu</label> <input
								id="hideEasing" type="text" placeholder="swing, linear"
								class="form-control" value="강남구" />
						</div>
						<div class="form-group">
							<label for="showMethod">Dong</label> <input
								id="showMethod" type="text"
								placeholder="show, fadeIn, slideDown" class="form-control"
								value="테헤란로 606" />
						</div>
					</div>

					<div class="col-md-3">
						<h5>Number of Rooms</h5>
						<div class="form-group">
							<label class="form-label" for="showDuration">Total
								</label> <input id="showDuration" type="number" placeholder="ms"
								class="form-control" value="120" />
						</div>
					</div>
				</div>
			</div>
			<div class="card-footer d-block clearfix">
				<div class="float-left">
					<button type="button" class="btn btn-link text-danger"
						id="cleartoasts">Clear Toasts</button>
					<button type="button" class="btn btn-link" id="clearlasttoast">Clear
						Last Toast</button>
				</div>
				<div class="float-right">
					<button type="button" class="btn btn-success" id="showtoast">Register
						</button>
				</div>
			</div>
		</div>
	</div>
	<div class="tab-pane tabs-animation fade" id="tab-content-2"
		role="tabpanel">
		<div class="row">
			<div class="col-md-6">
				<div class="main-card mb-3 card">
					<div class="card-body">
						<h5 class="card-title">Alerts</h5>
						<div class="alert alert-primary fade show" role="alert">This
							is a primary alert — check it out!</div>
						<div class="alert alert-secondary fade show" role="alert">This
							is a secondary alert — check it out!</div>
						<div class="alert alert-success fade show" role="alert">This
							is a success alert — check it out!</div>
						<div class="alert alert-danger fade show" role="alert">This
							is a danger alert — check it out!</div>
						<div class="alert alert-warning fade show" role="alert">This
							is a warning alert — check it out!</div>
						<div class="alert alert-info fade show" role="alert">This is
							a info alert — check it out!</div>
						<div class="alert alert-light fade show" role="alert">This
							is a light alert — check it out!</div>
						<div class="alert alert-dark fade show" role="alert">This is
							a dark alert — check it out!</div>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="main-card mb-3 card">
					<div class="card-body">
						<h5 class="card-title">Alerts Link Color</h5>
						<div class="alert alert-primary fade show" role="alert">
							This is a primary alert with <a href="javascript:void(0);"
								class="alert-link">an example link</a>. Give it a click if you
							like.
						</div>
						<div class="alert alert-secondary fade show" role="alert">
							This is a secondary alert with <a href="javascript:void(0);"
								class="alert-link">an example link</a>. Give it a click if you
							like.
						</div>
						<div class="alert alert-success fade show" role="alert">
							This is a success alert with <a href="javascript:void(0);"
								class="alert-link">an example link</a>. Give it a click if you
							like.
						</div>
						<div class="alert alert-danger fade show" role="alert">
							This is a danger alert with <a href="javascript:void(0);"
								class="alert-link">an example link</a>. Give it a click if you
							like.
						</div>
						<div class="alert alert-warning fade show" role="alert">
							This is a warning alert with <a href="javascript:void(0);"
								class="alert-link">an example link</a>. Give it a click if you
							like.
						</div>
						<div class="alert alert-info fade show" role="alert">
							This is a info alert with <a href="javascript:void(0);"
								class="alert-link">an example link</a>. Give it a click if you
							like.
						</div>
						<div class="alert alert-light fade show" role="alert">
							This is a light alert with <a href="javascript:void(0);"
								class="alert-link">an example link</a>. Give it a click if you
							like.
						</div>
						<div class="alert alert-dark fade show" role="alert">
							This is a dark alert with <a href="javascript:void(0);"
								class="alert-link">an example link</a>. Give it a click if you
							like.
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="main-card mb-3 card">
					<div class="card-body">
						<h5 class="card-title">Alerts Content</h5>
						<div class="alert alert-success fade show" role="alert">
							<h4 class="alert-heading">Well done!</h4>
							<p>Aww yeah, you successfully read this important alert
								message. This example text is going to run a bit longer so that
								you can see how spacing within an alert works with this kind of
								content.</p>
							<hr>
							<p class="mb-0">Whenever you need to, be sure to use margin
								utilities to keep things nice and tidy.</p>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="main-card mb-3 card">
					<div class="card-body">
						<h5 class="card-title">Dismissable Alerts</h5>
						<div class="alert alert-info alert-dismissible fade show"
							role="alert">
							<button type="button" class="close" aria-label="Close">
								<span aria-hidden="true">×</span>
							</button>
							I am an alert and I can be dismissed!
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles"%> -
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
	<script src="/lib/jquery/jquery.js"></script>
  <title>Quirk Responsive Admin Templates</title>
</head>

<script>
$(document).ready(function(){
	'use strict';
	var m1 = new Morris.Line({
		element: 'line-chart',
		data: [
		{ y: '2019-01-01', a: 30,  b: 20 },
		{ y: '2019-01-02', a: 75,  b: 65 },
		{ y: '2019-01-03', a: 50,  b: 40 },
		{ y: '2019-01-04', a: 75,  b: 65 },
		{ y: '2019-01-05', a: 50,  b: 40 },
		{ y: '2019-01-06', a: 75,  b: 65 },
		{ y: '2019-01-07', a: 800000, b: 90 }
			],
		xkey: 'y',
		ykeys: ['a', 'b'],
		labels: ['매입', '매출'],
		lineColors: ['#D9534F', '#5BC0DE'],
		//pointFillColors: ['#fff', '#000'],
		lineWidth: '3px',
		hideHover: true,
		gridTextColor: '#fff',
		grid: false
	});
});
</script>
<body>
<section>
  <div class="mainpanel">
    <div class="contentpanel">
      <div class="row">
        <div class="col-md-9 col-lg-8 dash-left">          
          <div class="row row-col-join panel-earnings">
            <div class="col-xs-3 col-sm-4 col-lg-3">
              <div class="panel">
                <ul class="panel-options">
                  <li><a><i class="glyphicon glyphicon-option-vertical"></i></a></li>
                </ul>
                <div class="panel-heading">
                  <h4 class="panel-title">Total Earnings</h4>
                </div>
                <div class="panel-body">
                  <h3 class="earning-amount">$1,543.03</h3>
                  <h4 class="earning-today">Today's Earnings</h4>

                  <ul class="list-group">
                    <li class="list-group-item">This Week <span class="pull-right">$12,320.34</span></li>
                    <li class="list-group-item">This Month <span class="pull-right">$37,520.34</span></li>
                  </ul>
                  <hr class="invisible">
                  <p>Total items sold this month: 411</p>
                </div>
              </div><!-- panel -->
            </div>
            <div class="col-xs-9 col-sm-8 col-lg-9">
              <div class="panel">
                <div class="panel-heading">
                  <h4 class="panel-title">해당 부서별 매입/매출 현황</h4>
                </div>
                <div class="panel-body">
                  <div id="line-chart" class="body-chart"></div>
                </div>
              </div>
            </div>
          </div>
		<!-- 즐겨 찾기  -->
          <div class="row panel-quick-page">
            <div class="col-xs-4 col-sm-5 col-md-4 page-user">
              <div class="panel">
                <div class="panel-heading">
                  <h4 class="panel-title">Manage Users</h4>
                </div>
                <div class="panel-body">
                  <div class="page-icon"><i class="icon ion-person-stalker"></i></div>
                </div>
              </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4 page-products">
              <div class="panel">
                <div class="panel-heading">
                  <h4 class="panel-title">Manage Products</h4>
                </div>
                <div class="panel-body">
                  <div class="page-icon"><i class="fa fa-shopping-cart"></i></div>
                </div>
              </div>
            </div>
            <div class="col-xs-4 col-sm-3 col-md-2 page-events">
              <div class="panel">
                <div class="panel-heading">
                  <h4 class="panel-title">Events</h4>
                </div>
                <div class="panel-body">
                  <div class="page-icon"><i class="icon ion-ios-calendar-outline"></i></div>
                </div>
              </div>
            </div>
            <div class="col-xs-4 col-sm-3 col-md-2 page-messages">
              <div class="panel">
                <div class="panel-heading">
                  <h4 class="panel-title">Messages</h4>
                </div>
                <div class="panel-body">
                  <div class="page-icon"><i class="icon ion-email"></i></div>
                </div>
              </div>
            </div>
            <div class="col-xs-4 col-sm-5 col-md-2 page-reports">
              <div class="panel">
                <div class="panel-heading">
                  <h4 class="panel-title">Reports</h4>
                </div>
                <div class="panel-body">
                  <div class="page-icon"><i class="icon ion-arrow-graph-up-right"></i></div>
                </div>
              </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-2 page-statistics">
              <div class="panel">
                <div class="panel-heading">
                  <h4 class="panel-title">Statistics</h4>
                </div>
                <div class="panel-body">
                  <div class="page-icon"><i class="icon ion-ios-pulse-strong"></i></div>
                </div>
              </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4 page-support">
              <div class="panel">
                <div class="panel-heading">
                  <h4 class="panel-title">Manage Support</h4>
                </div>
                <div class="panel-body">
                  <div class="page-icon"><i class="icon ion-help-buoy"></i></div>
                </div>
              </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-2 page-privacy">
              <div class="panel">
                <div class="panel-heading">
                  <h4 class="panel-title">Privacy</h4>
                </div>
                <div class="panel-body">
                  <div class="page-icon"><i class="icon ion-android-lock"></i></div>
                </div>
              </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-2 page-settings">
              <div class="panel">
                <div class="panel-heading">
                  <h4 class="panel-title">Settings</h4>
                </div>
                <div class="panel-body">
                  <div class="page-icon"><i class="icon ion-gear-a"></i></div>
                </div>
              </div>
            </div>
          </div><!-- row -->
        </div><!-- col-md-9 -->
        <!-- 즐겨 찾기  -->
        
        
        <div class="col-md-3 col-lg-4 dash-right">
          <div class="row">
          <!-- 크롤링 날씨 데이터 -->
           <!--  <div class="col-sm-5 col-md-12 col-lg-6">
              <div class="panel panel-danger panel-weather">
                <div class="panel-heading">
                  <h4 class="panel-title">Weather Forecast</h4>
                </div>
                <div class="panel-body inverse">
                  <div class="row mb10">
                    <div class="col-xs-6">
                      <h2 class="today-day">Monday</h2>
                      <h3 class="today-date">July 13, 2015</h3>
                    </div>
                    <div class="col-xs-6">
                      <i class="wi wi-hail today-cloud"></i>
                    </div>
                  </div>
                  <p class="nomargin">Thunderstorm in the area of responsibility this afternoon through this evening.</p>
                  <div class="row mt10">
                    <div class="col-xs-7">
                      <strong>Temperature:</strong> (Celcius) 19
                    </div>
                    <div class="col-xs-5">
                      <strong>Wind:</strong> 30+ mph
                    </div>
                  </div>
                </div>
              </div>
            </div> --><!-- col-md-12 -->
            <!-- 크롤링 날씨 데이터 -->
            
            <!-- 공지 사항 -->
            <div class="col-sm-5 col-md-12 col-lg-6">
              <div class="panel panel-primary list-announcement">
                <div class="panel-heading">
                  <h4 class="panel-title">휴가 결재 승인</h4>
                </div>
                <div class="panel-body">
                  <ul class="list-unstyled mb20">
                    <li>
                      <img src="/images/Icon_gray.gif" >
                      <a >결재 요청</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                      <a>2 shares</a>
                    </li>
                    <li>
                      <img src="/images/Icon_orange.gif" >
                      <a >결재 진행중</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                      <a>2 shares</a>
                    </li>
                    <li>
                      <img src="/images/Icon_red.gif" >
                      <a >반려</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                      <a>2 shares</a>
                    </li>
                  </ul>
                </div>
                <div class="panel-footer">
                  <button class="btn btn-primary btn-block" id="leaveAppApproval2">View More Announcements <i class="fa fa-arrow-right"></i></button>
                </div>
              </div>
            </div><!-- col-md-12 -->
            <!-- 공지 사항 -->
            
            <!-- 건의 사항 -->
            <div class="col-sm-5 col-md-12 col-lg-6">
              <div class="panel panel-primary list-announcement">
                <div class="panel-heading">
                  <h4 class="panel-title">건의 사항</h4>
                </div>
                <div class="panel-body">
                  <ul class="list-unstyled mb20">
                    <li>
                      <a >Testing Credit Card Payments on.</a>
                      <small>June 30, 2015 <a >7 shares</a></small>
                    </li>
                    <li>
                      <a >A Shopping Cart for New and.</a>
                      <small>June 15, 2015 &nbsp; <a >11 shares</a></small>
                    </li>
                    <li>
                      <a >A Shopping Cart for New and.</a>
                      <small>June 15, 2015 &nbsp; <a >2 shares</a></small>
                    </li>
                  </ul>
                </div>
                <div class="panel-footer">
                  <button class="btn btn-primary btn-block" >View More Announcements <i class="fa fa-arrow-right"></i></button>
                </div>
              </div>
            </div><!-- col-md-12 -->
             <!-- 건의 사항 -->
          </div><!-- row -->

          <!-- <div class="row">
          	최근 사용 내견 
            <div class="col-sm-5 col-md-12 col-lg-6">
              <div class="panel panel-success">
                <div class="panel-heading">
                  <h4 class="panel-title">최근 사용 내역</h4>
                </div>
                <div class="panel-body">
                  <ul class="media-list user-list">
                    <li class="media">
                      <div class="media-left">
                        <a href="#">
                          <img class="media-object img-circle" src="/images/photos/user2.png" alt="">
                        </a>
                      </div>
                      <div class="media-body">
                        <h4 class="media-heading nomargin"><a >Floyd M. Romero</a></h4>
                        is now following <a >Christina R. Hill</a>
                        <small class="date"><i class="glyphicon glyphicon-time"></i> Just now</small>
                      </div>
                    </li>
                    <li class="media">
                      <div class="media-left">
                        <a href="#">
                          <img class="media-object img-circle" src="/images/photos/user10.png" alt="">
                        </a>
                      </div>
                      <div class="media-body">
                        <h4 class="media-heading nomargin"><a >Roberta F. Horn</a></h4>
                        commented on <a >HTML5 Tutorial</a>
                        <small class="date"><i class="glyphicon glyphicon-time"></i> Yesterday</small>
                      </div>
                    </li>
                    <li class="media">
                      <div class="media-left">
                        <a href="#">
                          <img class="media-object img-circle" src="/images/photos/user3.png" alt="">
                        </a>
                      </div>
                      <div class="media-body">
                        <h4 class="media-heading nomargin"><a >Jennie S. Gray</a></h4>
                        posted a video on <a >The Discovery</a>
                        <small class="date"><i class="glyphicon glyphicon-time"></i> June 25, 2015</small>
                      </div>
                    </li>
                    <li class="media">
                      <div class="media-left">
                        <a href="#">
                          <img class="media-object img-circle" src="/images/photos/user5.png" alt="">
                        </a>
                      </div>
                      <div class="media-body">
                        <h4 class="media-heading nomargin"><a >Nicholas T. Hinkle</a></h4>
                        liked your video on <a >The Discovery</a>
                        <small class="date"><i class="glyphicon glyphicon-time"></i> June 24, 2015</small>
                      </div>
                    </li>
                    <li class="media">
                      <div class="media-left">
                        <a href="#">
                          <img class="media-object img-circle" src="/images/photos/user2.png" alt="">
                        </a>
                      </div>
                      <div class="media-body">
                        <h4 class="media-heading nomargin"><a >Floyd M. Romero</a></h4>
                        liked your photo on <a >My Life Adventure</a>
                        <small class="date"><i class="glyphicon glyphicon-time"></i> June 24, 2015</small>
                      </div>
                    </li>
                  </ul>
                </div>
              </div>panel
            </div>
            최근 사용 내용 
          </div>row -->

        </div><!-- col-md-3 -->
      </div><!-- row -->

    </div><!-- contentpanel -->

  </div><!-- mainpanel -->

</section>







</body>
</html>

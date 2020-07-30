// JavaScript模块化
var seckill = {
    //封装选课相关的ajax的url地址
    URL: {
        now: function () {
            return '/seckill/time/now';
        },
        exposer: function(seckillId){
            return '/seckill/' + seckillId + '/exposer';
        },
        execution : function(seckillId, md5){
            return '/seckill/' + seckillId + '/' + md5 + '/execution';
        }
    },
    //验证学号
    validateSno: function (sno) {
        if (sno && sno.length == 10 && !isNaN(sno)) {
            return true;
        } else {
            return false;
        }
    },
    //处理选课逻辑
    handleSeckill: function(seckillId, node){
        //获取选课地址，控制显示逻辑，执行选课操作
        node.hide().html('<button class="btn btn-primary btn-lg" id="killBtn">开始选课</button>');
        $.post(seckill.URL.exposer(seckillId), {}, function(result){
            //在回调函数中执行交互流程
            if (result && result['success']){
                var exposer = result['data'];
                if (exposer['exposed']){
                    //开启选课
                    var md5 = exposer['md5'];
                    var killUrl = seckill.URL.execution(seckillId, md5);
                    console.log('killUrl:' + killUrl);
                    //one: 绑定一次点击事件
                    $('#killBtn').one('click', function(){
                        //执行选课的操作
                        //1. 先禁用按钮
                        $(this).addClass('disabled');
                        //2. 发送选课请求，执行选课操作
                        $.post(killUrl, function(result){
                            if (result && result['success']){
                                var killResult = result['data'];
                                var stateInfo = killResult['stateInfo'];
                                //3. 显示选课结果
                                node.html('<span class="label label-success">' + stateInfo + '</span>');
                            }
                        })
                    });
                    node.show();
                } else{
                    //未开启选课，避免用户得到的时间有偏差
                    var now = exposer['now'];
                    var start = exposer['start'];
                    var end = exposer['end'];
                    seckill.countdown(seckillId, now, start, end);
                }
            } else{
                console.log('result:' + result);
            }
        });
    },
    //计时
    countdown: function (seckillId, nowTime, startTime, endTime) {
        var seckillBox = $('#seckill-box');
        var seckillTimeSpan = $('#seckill-time-span');
        //时间判断
        if (nowTime > endTime){
            //选课结束
            seckillTimeSpan.html('选课已结束');
            seckillBox.hide();
        }else if(nowTime < startTime){
            //说明选课未开始，计时事件绑定
            var killTime = new Date(startTime + 1000);
            seckillTimeSpan.countdown(killTime, function(event){
                //时间格式
                var format = event.strftime('距选课考试还有： %D天 %H时 %M分 %S秒');
                seckillTimeSpan.html(format);
                //时间完成后回调事件
            }).on('finish.countdown', function(){
                //获取选课地址，控制实现逻辑，执行选课操作
                seckill.handleSeckill(seckillId, seckillBox);
            });
        }else{
            //选课开始
            seckill.handleSeckill(seckillId, seckillBox);

            //计时
            var killEndTime = new Date(endTime + 1000);
            seckillTimeSpan.countdown(killEndTime, function(event){
                //时间格式
                var format = event.strftime('距离选课结束还有： %D天 %H时 %M分 %S秒');
                seckillTimeSpan.html(format);
            });
        }
    },
    //详情页选课逻辑
    detail: {
        //详情页初始化
        init: function (params) {
            //1、进行学号验证
            //在cookie中查询学生学号
            var killSno = $.cookie('killSno');
            //验证学号
            if (!seckill.validateSno(killSno)) {
                //绑定学号sno
                var killSnoModal = $('#killPhoneModal');
                killSnoModal.modal({
                    show: true,
                    backdrop: 'static', //禁止位置关闭
                    keyboard: false //关闭键盘事件
                });
                $("#killPhoneBtn").click(function () {
                    var inputSno = $('#killPhoneKey').val();
                    if (seckill.validateSno(inputSno)) {
                        //将学号写入cookie
                        $.cookie('killSno', inputSno, {expires: 7, path: '/seckill/'});
                        //刷新页面
                        window.location.reload();
                    } else {
                        $("#killPhoneMessage").hide().html('<lable class="label label-danger">学号错误！</lable>').show(300);
                    }
                });
            }
            //已经登录
            //计时交互
            var startTime = params['startTime'];
            var endTime = params['endTime'];
            var seckillId = params['seckillId'];
            //var money = params['money'];
            $.get(seckill.URL.now(), {}, function (result) {
                if (result && result['success']) {
                    var nowTime = result['data'];
                    //时间判断
                    seckill.countdown(seckillId, nowTime, startTime, endTime);
                } else {
                    console.log('result:' + result);
                }
            });
        }
    }
};
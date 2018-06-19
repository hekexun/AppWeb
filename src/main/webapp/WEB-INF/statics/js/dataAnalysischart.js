//第一图 累计历程图对比chart

window.onload=start_mile();
function start_mile() {
    var worldMapContainer1 = document.getElementById("chart1");
    var myChart1= echarts.init(worldMapContainer1);
    // Generate data
    var category = [];
    var dottedBase = +new Date();
    var lineData = [];
    var barData = [];

    for (var i = 0; i < 20; i++) {
        var date = new Date(dottedBase += 3600 * 24 * 1000);
        category.push([
            date.getFullYear(),
            date.getMonth() + 1,
            date.getDate()
        ].join('-'));
        var b = Math.random() * 200;
        var d = Math.random() * 200;
        barData.push(b)
        lineData.push(d + b);
    }

    var option_mile ={
       backgroundColor: '#0f375f',
       tooltip: {
           trigger: 'axis',
           axisPointer: {
               type: 'shadow'
           }
       },
       legend: {
           data: ['line', 'bar'],
           textStyle: {
               color: '#ccc'
           }
       },
       xAxis: {
           data: category,
           axisLine: {
               lineStyle: {
                   color: '#ccc'
               }
           }
       },
       yAxis: {
           splitLine: {show: false},
           axisLine: {
               lineStyle: {
                   color: '#ccc'
               }
           }
       },
       series: [{
           name: 'line',
           type: 'line',
           smooth: true,
           showAllSymbol: true,
           symbol: 'emptyCircle',
           symbolSize: 15,
           data: lineData
       }, {
           name: 'bar',
           type: 'bar',
           barWidth: 10,
           itemStyle: {
               normal: {
                   barBorderRadius: 5,
                   color: new echarts.graphic.LinearGradient(
                       0, 0, 0, 1,
                       [
                           {offset: 0, color: '#14c8d4'},
                           {offset: 1, color: '#43eec6'}
                       ]
                   )
               }
           },
           data: barData
       }, {
           name: 'line',
           type: 'bar',
           barGap: '-100%',
           barWidth: 10,
           itemStyle: {
               normal: {
                   color: new echarts.graphic.LinearGradient(
                       0, 0, 0, 1,
                       [
                           {offset: 0, color: 'rgba(20,200,212,0.5)'},
                           {offset: 0.2, color: 'rgba(20,200,212,0.2)'},
                           {offset: 1, color: 'rgba(20,200,212,0)'}
                       ]
                   )
               }
           },
           z: -12,
           data: lineData
       }, {
           name: 'dotted',
           type: 'pictorialBar',
           symbol: 'rect',
           itemStyle: {
               normal: {
                   color: '#0f375f'
               }
           },
           symbolRepeat: true,
           symbolSize: [12, 4],
           symbolMargin: 1,
           z: -10,
           data: lineData
       }]
   };

    myChart1.setOption(option_mile);
}

//第二图，油耗对比图的chart
window.onload=start_oil();
function start_oil() {
    var worldMapContainer2 = document.getElementById("chart2");
    var myChart2 = echarts.init(worldMapContainer2);
    option_oil = {
        title : {
            text: '车辆油耗',
            subtext: 'Data From CCRT'
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['测试油耗','社会油耗']
        },
        toolbox: {
            show : true,
            feature : {
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                data : ['阿特兹','福睿斯','途观','自由光','MG6','宝马3','CR-V','冠道']
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'CCRT油耗',
                type:'bar',
                data:[9.0, 9.0, 10.1, 10.2, 9.7, 9.5, 8.7, 9.0],
                markPoint : {
                    data : [
                        {type : 'max', name: '最大值'},
                        {type : 'min', name: '最小值'}
                    ]
                },
                markLine : {
                    data : [
                        {type : 'average', name: '平均值'}
                    ]
                }
            },
            {
                name:'社会油耗',
                type:'bar',
                data:[8.79, 8.54, 10.79, 10.2, 9.8, 9.20, 8.60, 9.50],
                markPoint : {
                    data : [
                        {name : '年最高', value : 182.2, xAxis: 7, yAxis: 183},
                        {name : '年最低', value : 2.3, xAxis: 11, yAxis: 3}
                    ]
                },
                markLine : {
                    data : [
                        {type : 'average', name : '平均值'}
                    ]
                }
            }
        ]
    };
    myChart2.setOption(option_oil);
}

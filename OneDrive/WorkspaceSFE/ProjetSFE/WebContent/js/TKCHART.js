 $(function () {

    $(document).ready(function () {
        Highcharts.setOptions({
            global: {
                useUTC: false
            }
        });
        
        var dData = function() {
  		  return $('#formid span').text();
  		};
        
       // alert("dfg");
   	 Chart.types.Doughnut.extend({
         name: "DoughnutTextInside",
         showTooltip: function() {
             this.chart.ctx.save();
             Chart.types.Doughnut.prototype.showTooltip.apply(this, arguments);
             this.chart.ctx.restore();
         },
         draw: function() {
             Chart.types.Doughnut.prototype.draw.apply(this, arguments);

             var width = this.chart.width,
                 height = this.chart.height;

             var fontSize = (height / 114).toFixed(2);
             this.chart.ctx.font = fontSize + "em Verdana";
             this.chart.ctx.textBaseline = "middle";

             var text = dData() + "%",
                 textX = Math.round((width - this.chart.ctx.measureText(text).width) / 2),
                 textY = height / 2;

             this.chart.ctx.fillText(text, textX, textY);
         }
     });

     var data = [{
         value: dData(),
         color: "#F7464A"
     }, {
         value: 100-parseInt(dData(), 10),
         color: "#4D5360"
     }];

     var DoughnutTextInsideChart = new Chart($('#chartmem')[0].getContext('2d')).DoughnutTextInside(data, {
         responsive: true
     });


       
           
        $('#container').highcharts({
            chart: {
                type: 'spline',
                animation: Highcharts.svg, // don't animate in old IE
                marginRight: 10,
                events: {
                    load: function () {

                        // set up the updating of the chart each second
                        var series = this.series[0];
                        setInterval(function () {
                            var x = (new Date()).getTime(), // current time
                                y = parseInt(dData());
                            series.addPoint([x, y], true, true);
                        }, 1000);
                    }
                }
            },
            title: {
                text: 'Utilisation du CPU en temps r\351el'
            },
            xAxis: {
                type: 'datetime',
                tickPixelInterval: 150
            },
            yAxis: {
                title: {
                    text: 'Value'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                formatter: function () {
                    return '<b>' + this.series.name + '</b><br/>' +
                        'Date : ' + Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
                        'Utilisation CPU : ' + Highcharts.numberFormat(this.y, 0) + ' %';
                }
            },
            legend: {
                enabled: false
            },
            exporting: {
                enabled: false
            },
            credits: {
                enabled: false
            },
            series: [{
                name: '',
                data: (function () {
                    // generate an array of random data
                    var data = [],
                        time = (new Date()).getTime(),
                        i;

                    for (i = -19; i <= 0; i += 1) {
                        data.push({
                            x: time + i * 1000,
                            y: (Math.random()*50) + 8
                        });
                    }
                    return data;
                }())
            }]
        });
    });
});

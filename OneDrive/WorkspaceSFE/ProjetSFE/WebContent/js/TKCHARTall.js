 $(function () {

    $(document).ready(function () {
        Highcharts.setOptions({
            global: {
                useUTC: false
            }
        });
        
        var dData = function() {
  		  return $("#formid\\:txt_count").text();
  		};
  	  var dDatamem = function() {
  		  return $("#formid\\:txt_ram").text();
  		};
  		
  		var dDatanetin = function() {
    		  return $("#formid\\:txt_netin").text();
    		};
    		var dDatanetout = function() {
      		  return $("#formid\\:txt_netout").text();
      		};
       // alert("dfg");
   	/* Chart.types.Doughnut.extend({
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

*/
  		Highcharts.createElement('link', {
  		   href: 'https://fonts.googleapis.com/css?family=Unica+One',
  		   rel: 'stylesheet',
  		   type: 'text/css'
  		}, null, document.getElementsByTagName('head')[0]);

  	/*	Highcharts.theme = {
  		   colors: ["#2b908f", "#90ee7e", "#f45b5b", "#7798BF", "#aaeeee", "#ff0066", "#eeaaee",
  		      "#55BF3B", "#DF5353", "#7798BF", "#aaeeee"],
  		   chart: {
  		      backgroundColor: {
  		         linearGradient: { x1: 0, y1: 0, x2: 1, y2: 1 },
  		         stops: [
  		            [0, '#2a2a2b'],
  		            [1, '#3e3e40']
  		         ]
  		      },
  		      style: {
  		         fontFamily: "'Unica One', sans-serif"
  		      },
  		      plotBorderColor: '#606063'
  		   },
  		   title: {
  		      style: {
  		         color: '#E0E0E3',
  		         textTransform: 'uppercase',
  		         fontSize: '20px'
  		      }
  		   },
  		   subtitle: {
  		      style: {
  		         color: '#E0E0E3',
  		         textTransform: 'uppercase'
  		      }
  		   },
  		   xAxis: {
  		      gridLineColor: '#707073',
  		      labels: {
  		         style: {
  		            color: '#E0E0E3'
  		         }
  		      },
  		      lineColor: '#707073',
  		      minorGridLineColor: '#505053',
  		      tickColor: '#707073',
  		      title: {
  		         style: {
  		            color: '#A0A0A3'

  		         }
  		      }
  		   },
  		   yAxis: {
  		      gridLineColor: '#707073',
  		      labels: {
  		         style: {
  		            color: '#E0E0E3'
  		         }
  		      },
  		      lineColor: '#707073',
  		      minorGridLineColor: '#505053',
  		      tickColor: '#707073',
  		      tickWidth: 1,
  		      title: {
  		         style: {
  		            color: '#A0A0A3'
  		         }
  		      }
  		   },
  		   tooltip: {
  		      backgroundColor: 'rgba(0, 0, 0, 0.85)',
  		      style: {
  		         color: '#F0F0F0'
  		      }
  		   },
  		   plotOptions: {
  		      series: {
  		         dataLabels: {
  		            color: '#B0B0B3'
  		         },
  		         marker: {
  		            lineColor: '#333'
  		         }
  		      },
  		      boxplot: {
  		         fillColor: '#505053'
  		      },
  		      candlestick: {
  		         lineColor: 'white'
  		      },
  		      errorbar: {
  		         color: 'white'
  		      }
  		   },
  		   legend: {
  		      itemStyle: {
  		         color: '#E0E0E3'
  		      },
  		      itemHoverStyle: {
  		         color: '#FFF'
  		      },
  		      itemHiddenStyle: {
  		         color: '#606063'
  		      }
  		   },
  		   credits: {
  		      style: {
  		         color: '#666'
  		      }
  		   },
  		   labels: {
  		      style: {
  		         color: '#707073'
  		      }
  		   },

  		   drilldown: {
  		      activeAxisLabelStyle: {
  		         color: '#F0F0F3'
  		      },
  		      activeDataLabelStyle: {
  		         color: '#F0F0F3'
  		      }
  		   },

  		   navigation: {
  		      buttonOptions: {
  		         symbolStroke: '#DDDDDD',
  		         theme: {
  		            fill: '#505053'
  		         }
  		      }
  		   },

  		   // scroll charts
  		   rangeSelector: {
  		      buttonTheme: {
  		         fill: '#505053',
  		         stroke: '#000000',
  		         style: {
  		            color: '#CCC'
  		         },
  		         states: {
  		            hover: {
  		               fill: '#707073',
  		               stroke: '#000000',
  		               style: {
  		                  color: 'white'
  		               }
  		            },
  		            select: {
  		               fill: '#000003',
  		               stroke: '#000000',
  		               style: {
  		                  color: 'white'
  		               }
  		            }
  		         }
  		      },
  		      inputBoxBorderColor: '#505053',
  		      inputStyle: {
  		         backgroundColor: '#333',
  		         color: 'silver'
  		      },
  		      labelStyle: {
  		         color: 'silver'
  		      }
  		   },

  		   navigator: {
  		      handles: {
  		         backgroundColor: '#666',
  		         borderColor: '#AAA'
  		      },
  		      outlineColor: '#CCC',
  		      maskFill: 'rgba(255,255,255,0.1)',
  		      series: {
  		         color: '#7798BF',
  		         lineColor: '#A6C7ED'
  		      },
  		      xAxis: {
  		         gridLineColor: '#505053'
  		      }
  		   },

  		   scrollbar: {
  		      barBackgroundColor: '#808083',
  		      barBorderColor: '#808083',
  		      buttonArrowColor: '#CCC',
  		      buttonBackgroundColor: '#606063',
  		      buttonBorderColor: '#606063',
  		      rifleColor: '#FFF',
  		      trackBackgroundColor: '#404043',
  		      trackBorderColor: '#404043'
  		   },

  		   // special colors for some of the
  		   legendBackgroundColor: 'rgba(0, 0, 0, 0.5)',
  		   background2: '#505053',
  		   dataLabelsColor: '#B0B0B3',
  		   textColor: '#C0C0C0',
  		   contrastTextColor: '#F0F0F3',
  		   maskColor: 'rgba(255,255,255,0.3)'
  		};

  		// Apply the theme
  		Highcharts.setOptions(Highcharts.theme);
           */
  		$('#container').highcharts({
            chart: {
                type: 'area',
            	zoomType: 'x',
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
            	min: 0,
            	max: 100,
                title: {
                    text: 'Value'
                },
            plotOptions: {
                    line: {
                        marker: {
                            enabled: false
                        }
                    }
                }
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
            plotOptions: {
                area: {
                    fillColor: {
                        linearGradient: {
                            x1: 0,
                            y1: 0,
                            x2: 0,
                            y2: 1
                        },
                        stops: [
                            [0, Highcharts.getOptions().colors[0]],
                            [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
                        ]
                    },
                    marker: {
                        radius: 2
                    },
                    lineWidth: 1,
                    states: {
                        hover: {
                            lineWidth: 1
                        }
                    },
                    threshold: null
                }
            },
            series: [{
                name: '',
                marker: {
                    enabled: false
                 },
                data: (function () {
                    // generate an array of random data
                    var data = [],
                        time = (new Date()).getTime(),
                        i;

                    for (i = -259; i <= 0; i += 1) {
                        data.push({
                            x: time + i * 1000,
                            y: (Math.random()*20) + 3
                        });
                    }
                    return data;
                }())
            }]
        });
  		
  		
  		$('#containerMEM').highcharts({
            chart: {
                type: 'area',
            	zoomType: 'x',
                animation: Highcharts.svg, // don't animate in old IE
                marginRight: 10,
                events: {
                    load: function () {

                        // set up the updating of the chart each second
                        var series = this.series[0];
                        setInterval(function () {
                            var x = (new Date()).getTime(), // current time
                                y = parseInt(dDatamem());
                            series.addPoint([x, y], true, true);
                        }, 1000);
                    }
                }
            },
            title: {
                text: 'Utilisation de la memoire en temps r\351el'
            },
            xAxis: {
                type: 'datetime',
                tickPixelInterval: 150
            },
            yAxis: {
            	min: 0,
            	max: 100,
                title: {
                    text: 'Value'
                },
            plotOptions: {
                    line: {
                        marker: {
                            enabled: false
                        }
                    }
                }
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
            plotOptions: {
                area: {
                    fillColor: {
                        linearGradient: {
                            x1: 0,
                            y1: 0,
                            x2: 0,
                            y2: 1
                        },
                        stops: [
                            [0, Highcharts.getOptions().colors[0]],
                            [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
                        ]
                    },
                    marker: {
                        radius: 2
                    },
                    lineWidth: 1,
                    states: {
                        hover: {
                            lineWidth: 1
                        }
                    },
                    threshold: null
                }
            },
            series: [{
                name: '',
                marker: {
                    enabled: false
                 },
                data: (function () {
                    // generate an array of random data
                    var data = [],
                        time = (new Date()).getTime(),
                        i;

                    for (i = -259; i <= 0; i += 1) {
                    	if(i>-100)
                    	  data.push({  x: time + i * 1000,  y: 25  });
                    	else
                    		data.push({  x: time + i * 1000,  y: 15 });
                    }
                    return data;
                }())
            }]
        });
  		
  		$('#containerNET').highcharts({
            chart: {
                type: 'area',
            	zoomType: 'x',
                animation: Highcharts.svg, // don't animate in old IE
                marginRight: 10,
                events: {
                    load: function () {

                        // set up the updating of the chart each second
                        var series = this.series[0];
                        var series2 = this.series[1];
                        setInterval(function () {
                            var x = (new Date()).getTime(), // current time
                                y = parseInt(dDatanetin());
                            series.addPoint([x, y], true, true);
                            series2.addPoint([x, -1*parseInt(dDatanetout())], true, true);
                        }, 1000);
                    }
                }
            },
            title: {
                text: 'Utilisation du reseau en temps r\351el'
            },
            xAxis: {
                type: 'datetime',
                tickPixelInterval: 150
            },
            yAxis: {
            	
                title: {
                    text: 'Value'
                },
            plotOptions: {
                    line: {
                        marker: {
                            enabled: false
                        }
                    }
                }
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
            plotOptions: {
                area: {
                    fillColor: {
                        linearGradient: {
                            x1: 0,
                            y1: 0,
                            x2: 0,
                            y2: 1
                        },
                        stops: [
                            [0, Highcharts.getOptions().colors[0]],
                            [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
                        ]
                    },
                    marker: {
                        radius: 2
                    },
                    lineWidth: 1,
                    states: {
                        hover: {
                            lineWidth: 1
                        }
                    },
                    threshold: null
                }
            },
            series: [{
                name: 'TX',
                marker: {
                    enabled: false
                 },
                data: (function () {
                    // generate an array of random data
                    var data = [],
                        time = (new Date()).getTime(),
                        i;

                    for (i = -259; i <= 0; i += 1) {
                    	
                    		data.push({  x: time + i * 1000,  y: 6});
                    }
                    return data;
                }())
            },
            {
            	name: 'RX',
            marker: {
                enabled: false
             },
            data: (function () {
                // generate an array of random data
                var data = [],
                    time = (new Date()).getTime(),
                    i;

                for (i = -259; i <= 0; i += 1) {
                	
                		data.push({  x: time + i * 1000,  y: 6 });
                }
                return data;
            }())
        }
            ]
        });
    });
});

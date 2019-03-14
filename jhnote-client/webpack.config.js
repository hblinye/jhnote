const path = require('path');
const webpack = require('webpack');
const extractTextPlugin = require("extract-text-webpack-plugin");
const VLP = require('vue-loader/lib/plugin')


module.exports = {
    mode: 'development',
    entry: {
        index: './src/index.js'
    },
    output: {
        path: path.resolve(__dirname, './build/js'),
        publicPath: './build',
        filename: '[name].js'
    },
    devServer: {
        historyApiFallback: true,
        overlay: true
    },
    resolve: {
        alias: {
            'vue$': 'vue/dist/vue.esm.js'
        }
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                use: {
                    loader: 'babel-loader'
                },
                exclude: /node_modules/
            },
            {
                test: /\.vue$/,
                use: {
                    loader: 'vue-loader'
                }
            },
            {
                test: /\.scss$/,
                use: extractTextPlugin.extract({
                    fallback: 'vue-style-loader',
                    use: [
                        'css-loader',
                        'sass-loader'
                    ]
                })
            }
        ]
    },
    plugins: [
        new extractTextPlugin("../css/[name].css"),
        new VLP()
    ]
};